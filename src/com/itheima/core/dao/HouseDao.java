package com.itheima.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.itheima.core.po.House;

public interface HouseDao {
	public List<House> selectHouseList(House house);//�����б�
	public Integer selectHouseListCount(House house);//������
	public House selectHouseByhno(@Param("hno") Integer hno);//��������
	public int insertHouse(House house);//��ӷ���
	public int updateHouse(House house);//���·�����Ϣ
	public int deleteHouseByhno(@Param("hno") Integer hno);//ɾ��������Ϣ
}
