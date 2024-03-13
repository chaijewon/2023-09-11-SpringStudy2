package com.sist.web.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.entity.Recipe;
import java.util.*;
public interface RecipeService extends JpaRepository<Recipe, Integer>{
   @Query(value="SELECT * FROM recipe2 "
		 +"ORDER BY no ASC LIMIT 0,5",nativeQuery = true)
   public List<Recipe> recipeMainList();
   
   @Query(value="SELECT * FROM recipe2 "
			 +"ORDER BY no ASC LIMIT :start,12",nativeQuery = true)
   public List<Recipe> recipeListData(@Param("start") int start);
}
