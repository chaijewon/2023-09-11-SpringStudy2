package com.sist.service;

import java.util.List;

import com.sist.vo.FoodVO;

public interface FoodService {
	// Food관련
	public List<FoodVO> foodListData(int start,int end);
	public int foodTotalPage();
	
	// Reply관련 
}
