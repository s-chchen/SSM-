package com.itheima.core.service;

import org.apache.ibatis.annotations.Param;

import com.itheima.common.utils.Page;
import com.itheima.core.po.Booking;
import com.itheima.core.po.User;

public interface BookingService {
	public Page<Booking> selectBookingList(Integer page,Integer rows,User btenantid,Booking booking);
	public int insertBooking(Booking booking);
	public Booking selectBookingBybno(Integer bno);//�鿴������Ϣ
	public int deleteBookingBybno(Integer bno);
}
