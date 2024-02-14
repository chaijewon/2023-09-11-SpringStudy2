package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FoodController {
   @GetMapping("food/food_find.do")
   public String food_find()
   {
	   return "food/food_find";
   }
   @GetMapping("food/food_list.do")
   public String food_list()
   {
	   return "food/food_list";
   }
}
