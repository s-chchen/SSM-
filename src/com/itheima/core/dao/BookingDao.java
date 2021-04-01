package com.itheima.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.itheima.core.po.Booking;

public interface BookingDao {
	public List<Booking> selectBookingList(Booking booking);//�����б�
	public Integer selectBookingListCount(Booking booking);//������
	public int insertBooking(Booking booking);//��Ӷ�����Ϣ
	public Booking selectBookingBybno(@Param("bno") Integer bno);//�鿴������Ϣ	
//	public int updateBooking(Booking booking);
	public int deleteBookingBybno(@Param("bno") Integer bno);
}
