package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.service.FoodService;
import com.sist.web.service.RecipeService;

import java.util.*;
import com.sist.web.entity.*;
@RestController
@CrossOrigin(origins = "*")
public class MainController {
	@Autowired
    private FoodService fService;
	
	@Autowired
	private RecipeService rService;
	
	@GetMapping("/")
	public List<Food> foodMainData(){
		List<Food> list=fService.foodMainData();
		for(Food vo:list)
		{
			vo.setPoster("http://www.menupan.com"+vo.getPoster());
		}
		return list;
	}
	@GetMapping("/main")
	public Food foodMainVO() {
		Food food=fService.findByFno(180);
		return food;
	}
	@GetMapping("/recipe/main")
	public List<Recipe> recipeMainList(){
		return rService.recipeMainList();
	}
}
