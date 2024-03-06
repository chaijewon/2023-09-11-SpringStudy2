package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.web.dao.*;
import com.sist.web.entity.*;
@RestController
@CrossOrigin(origins = "*")
public class RecipeRestController {
   @Autowired
   private RecipeDAO dao;
   
   @Autowired
   private RecipedetailDAO rDao;
   
   @GetMapping("/recipe/list_react")
   public Map recipeListData(int page)
   {
	   int rowSize=12;
	   int start=(rowSize*page)-rowSize;
	   List<Recipe> list=dao.recipeListData(start);
	   
	   Map map=new HashMap();
	   int count=(int)dao.count();
	   int totalpage=(int)(Math.ceil(count/12.0));
	   final int BLOCK=10;
	   int startPage=((page-1)/BLOCK*BLOCK)+1;
	   int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
	   if(endPage>totalpage)
		   endPage=totalpage;
	   
	   map.put("curpage",page);
	   map.put("totalpage",totalpage);
	   map.put("startPage",startPage);
	   map.put("endPage", endPage);
	   map.put("count", count);
	   map.put("list", list);
	   
	   return map;
   }
   @GetMapping("/recipe/detail_react")
   public Map recipeDetailData(int no)
   {
	   Map map=new HashMap();
	   Recipedetail r=rDao.findByNo(no);
	   String[] fm=r.getFoodmake().split("\n");
	   List<String> make=new ArrayList<String>();
	   List<String> image=new ArrayList<String>();
	   for(String food:fm)
	   {
		   StringTokenizer st=new StringTokenizer(food,"^");
		   make.add(st.nextToken());
		   image.add(st.nextToken());
	   }
	   map.put("recipe", r);
	   map.put("make", make);
	   map.put("image", image);
	   return map;
   }
}
