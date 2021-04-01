package com.itheima.core.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.core.po.User;
import com.itheima.core.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping(value="/login.action",method=RequestMethod.POST)
	public String login(String userid,String password,Model model,HttpSession session) {
		User user=userService.selectUser(userid, password);
		if(user!=null) {
			session.setAttribute("USER_SESSION", user);
			return "redirect:house/list.action";
		}
		model.addAttribute("msg", "�˺���������������룡");
		return "login";
	}
	@RequestMapping("/toHouse.action")
	public String toHouse() {
		return "house2";
	}
	@RequestMapping("/logout.action")
	public String logout(HttpSession session) {
		session.invalidate();/* ���Session */
		return "redirect:login.action";
	}
	@RequestMapping(value="/login.action",method=RequestMethod.GET)
	public String toLogin() {
		return "login";
	}
	/* �û�ע�� */
	@RequestMapping(value="/register.action")
	@ResponseBody
	public String insertUser(User user,HttpSession session) {		
		User user2=userService.selectUser(user.getUserid(), null);
		if(user2==null) {
			int rows=userService.insertUser(user);
			if(rows > 0){
				return "OK";
			}else{
				return "FAIL";
			}
		}else {
			return "exist";
		}
	}
	/* �鿴������Ϣ */
	@RequestMapping("/userdetail.action")
	public String detailUser() {
		return "userdetail";
	}
	/* ���¸�����Ϣ */
	@RequestMapping("/user/update.action")
	@ResponseBody
	public String updateUser(User user,HttpSession session) {
		int rows=userService.updateUser(user);
		session.setAttribute("USER_SESSION", user);
		if(rows>0) {
			return "OK";
		}else {
			return "FALL";
		}
	}
	@RequestMapping("/user/getUserById.action")
	@ResponseBody
	public User getUserById(String userid) {
		User user=userService.selectUser(userid, null);
		return user;
	}
}
