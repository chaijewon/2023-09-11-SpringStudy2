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
    
    @Autowired
    private MemberDAO mDao;
    // ReplyDAO
    public List<FoodVO> foodListData(int start,int end)
    {
    	return dao.foodListData(start, end);
    }
	public int foodTotalPage()
	{
	    return dao.foodTotalPage();	
	}
	@Override
	public FoodVO foodDetailData(int fno) {
		// TODO Auto-generated method stub
		return dao.foodDetailData(fno);
	}
	@Override
	public MemberVO isLogin(String id, String pwd) {
		// TODO Auto-generated method stub
		return mDao.isLogin(id, pwd);
	}
    
}
