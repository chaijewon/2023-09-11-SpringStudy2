package com.sist.web.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.entity.*;
import com.sist.web.dao.*;
@RestController
@CrossOrigin(origins = "*")
public class FoodRestController {
   @Autowired
   private FoodDAO dao;
   
   @GetMapping("food/find_totalpage_react")
   public String find_totalpage(String address)
   {
	   int total=dao.foodFindTotalPage(address);
	   return String.valueOf(total);
   }
   @RequestMapping("/food/find_react")
   public List<FoodEntity> food_find(int page,String address)
   {
	   int rowSize=12;
	   int start=(rowSize*page)-rowSize;
	   List<FoodEntity> list=dao.foodFindData(start, address);
	   /*Map map=new HashMap();
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
	   map.put("list", list);*/
	   return list;
   }
   @GetMapping("/food/list_react")
   public List<FoodEntity> food_list(int page)
   {
	   System.out.println("page:"+page);
	   int rowSize=12;
	   int start=(rowSize*page)-rowSize;
	   List<FoodEntity> list=dao.foodListData(start);
	   /*Map map=new HashMap();
	   int totalpage=dao.foodListTotalPage();
	   final int BLOCK=10;
	   int startPage=((page-1)/BLOCK*BLOCK)+1;
	   int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
	   if(endPage>totalpage)
		   endPage=totalpage;
	   
	   map.put("curpage",page);
	   map.put("totalpage",totalpage);
	   map.put("startPage",startPage);
	   map.put("endPage", endPage);
	   map.put("list", list);*/
	   
	   return list;// response.data
	   
   }
   @GetMapping("food/food_totalpage_react")
   public String food_totalpage()
   {
	   int total=dao.foodListTotalPage();
	   return String.valueOf(total);
   }
   
   @GetMapping("food/food_detail_react")
   public FoodEntity food_detail(int fno)
   {
	   FoodEntity vo=dao.findByFno(fno);
	   return vo;
   }
}
