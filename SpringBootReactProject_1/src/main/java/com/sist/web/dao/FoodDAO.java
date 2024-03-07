package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.entity.FoodEntity;
import java.util.*;
public interface FoodDAO extends JpaRepository<FoodEntity, Integer>{
   @Query(value="SELECT * FROM food_house "
		 +"WHERE address LIKE CONCAT('%',:address,'%') "
		 +"ORDER BY fno ASC LIMIT :start,12",nativeQuery = true)
   public List<FoodEntity> foodFindData(@Param("start") Integer start,@Param("address") String address);
   
   @Query(value="SELECT CEIL(COUNT(*)/12.0) FROM food_house "
		 +"WHERE address LIKE CONCAT('%',:address,'%')",nativeQuery = true)
   public int foodFindTotalPage(@Param("address") String address);
   
   public FoodEntity findByFno(int fno);
   
   @Query(value="SELECT * FROM food_house "
		 +"ORDER BY fno ASC LIMIT :start,12",nativeQuery = true)
   public List<FoodEntity> foodListData(@Param("start") Integer start);
	   
   @Query(value="SELECT CEIL(COUNT(*)/12.0) FROM food_house"
		 ,nativeQuery = true)
  public int foodListTotalPage();
}
