package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;

// 스프링에 관리 요청 => interface/VO(데이터형)
@Repository  // id(foodDAO)
public class FoodDAO {
   @Autowired
   private FoodMapper mapper;
   // 인터페이스를 구현한 클래스 
   public List<FoodVO> foodListData(int start,int end)
   {
	   return mapper.foodListData(start, end);
   }
   
   public int foodTotalPage()
   {
	   return mapper.foodTotalPage();
   }
}
