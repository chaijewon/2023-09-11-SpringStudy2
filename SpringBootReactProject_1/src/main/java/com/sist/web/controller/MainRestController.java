package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.web.entity.*;
import com.sist.web.dao.*;
@RestController
@CrossOrigin(origins = "*")
public class MainRestController {
   @Autowired
   public RecipeDAO dao;
   @GetMapping("/")
   public List<Recipe>  recipeMainData()
   {
	   return dao.recipeListData(0);
   }
}
