package com.sist.web.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.web.entity.*;
@Service
public interface FoodService extends JpaRepository<Food, Integer>{
   @Query(value = "SELECT * FROM food_house "
		         +"ORDER BY fno ASC LIMIT 0,8"
		   ,nativeQuery = true)
   public List<Food> foodMainData();
   
   public Food findByFno(int fno);
}
