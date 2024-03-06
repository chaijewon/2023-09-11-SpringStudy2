package com.sist.web.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.entity.*;
import com.sist.web.dao.*;
@RestController
@CrossOrigin(origins = "*")
public class FoodRestController {
   @Autowired
   private FoodDAO dao;
   
   @RequestMapping("/food/find_react")
   public Map food_find(int page,String address)
   {
	   int rowSize=12;
	   int start=(rowSize*page)-rowSize;
	   List<FoodEntity> list=dao.foodFindData(start, address);
	   Map map=new HashMap();
	   int totalpage=dao.foodFindTotalPage(address);
	   final int BLOCK=10;
	   int startPage=((page-1)/BLOCK*BLOCK)+1;
	   int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
	   if(endPage>totalpage)
		   endPage=totalpage;
	   
	   map.put("curpage",page);
	   map.put("totalpage",totalpage);
	   map.put("startPage",startPage);
	   map.put("endPage", endPage);
	   map.put("list", list);
	   return map;
   }
}
