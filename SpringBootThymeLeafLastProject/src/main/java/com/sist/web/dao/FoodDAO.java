package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.entity.FoodEntity;
import com.sist.web.entity.FoodListVO;

import java.util.*;
// => 85%
public interface FoodDAO extends JpaRepository<FoodEntity, Integer>{
   @Query(value="SELECT fno,name,poster "
		       +"FROM food_house ORDER BY fno ASC "
		       +"LIMIT :start,20",nativeQuery = true)
   public List<FoodListVO> foodListData(@Param("start") int start);
   
   @Query(value="SELECT CEIL(COUNT(*)/20.0) FROM food_house",nativeQuery = true)
   public int foodTotalPage();
   
   
   public FoodEntity findByFno(int fno);
   
   // 1. 일반 SQL => 데이터베이스 , 2. JPQL(JOIN) => Entity클래스  , 3. 메소드 규칙 
   // JPA => ORM (데이터베이스와 Entity객체 매핑)
   
   @Query(value="SELECT fno,name,poster "
	       +"FROM food_house WHERE address LIKE CONCAT('%',:address,'%') "
	       +"LIMIT :start,20",nativeQuery = true)
   public List<FoodListVO> foodFindData(@Param("start") Integer start,@Param("address") String address);

   @Query(value="SELECT CEIL(COUNT(*)/20.0) FROM food_house "
		 +"WHERE address LIKE CONCAT('%',:address,'%')" 
		 ,nativeQuery = true)
   public int foodFindTotalPage(@Param("address") String address);
}
