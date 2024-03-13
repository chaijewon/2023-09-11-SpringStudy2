package com.sist.web.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.entity.*;
import com.sist.web.service.*;
@RestController
@CrossOrigin(origins = "*")
public class RecipeController {
	@Autowired
    private RecipeService rService;
	
	@GetMapping("/recipe/list_react")
	public Map recipe_list(int page)
	{
		int rowSize=12;
		int start=(rowSize*page)-rowSize;
		List<Recipe> list=rService.recipeListData(start);
		int count=(int)rService.count();
		int totalpage=(int)(Math.ceil(count/12.0));
		
		Map map=new HashMap();
		map.put("recipe_list", list);
		map.put("totalpage", totalpage);
		
		return map;
	}
}
