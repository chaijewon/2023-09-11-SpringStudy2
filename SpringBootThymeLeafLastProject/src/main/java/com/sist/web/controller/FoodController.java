package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.sist.web.dao.*;
import com.sist.web.entity.*;
@Controller
public class FoodController {
   @Autowired
   private FoodDAO dao;
   
   @Autowired
   private ReplyDAO rDao;
   
   @GetMapping("/food/list")
   public String food_list(String page,Model model)
   {
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   int rowSize=20;
	   int start=(rowSize*curpage)-rowSize;
	   List<FoodListVO> list=dao.foodListData(start);
	   int totalpage=dao.foodTotalPage();
	   final int BLOCK=10;
	   int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	   int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	   
	   if(endPage>totalpage)
		   endPage=totalpage;
	   
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   model.addAttribute("startPage", startPage);
	   model.addAttribute("endPage", endPage);
	   model.addAttribute("list", list);
	   model.addAttribute("main_html", "food/list");
	   return "main";
   }
   @GetMapping("/food/detail")
   public String food_detail(int fno,Model model)
   {
	   List<Reply> list=rDao.replyListData(fno);
	   FoodEntity vo=dao.findByFno(fno);
	   model.addAttribute("vo", vo);
	   model.addAttribute("list", list);
	   model.addAttribute("main_html", "food/detail");
	   return "main";
   }
   @RequestMapping("/food/find")
   public String food_find(String page,String address,Model model)
   {
	   if(address==null)
		   address="마포";
	   
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   int rowSize=20;
	   int start=(rowSize*curpage)-rowSize;
	   List<FoodListVO> list=dao.foodFindData(start,address);
	   int totalpage=dao.foodFindTotalPage(address);
	   final int BLOCK=10;
	   int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	   int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	   
	   if(endPage>totalpage)
		   endPage=totalpage;
	   
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   model.addAttribute("startPage", startPage);
	   model.addAttribute("endPage", endPage);
	   model.addAttribute("list", list);
       model.addAttribute("address", address);
	   model.addAttribute("main_html", "food/find");
	   return "main";
   }
}
