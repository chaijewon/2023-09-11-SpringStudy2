package com.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
@Service
public class FoodServiceImpl implements FoodService{
    @Autowired
	private FoodDAO dao;
    
    // ReplyDAO
    public List<FoodVO> foodListData(int start,int end)
    {
    	return dao.foodListData(start, end);
    }
	public int foodTotalPage()
	{
	    return dao.foodTotalPage();	
	}
    
}
