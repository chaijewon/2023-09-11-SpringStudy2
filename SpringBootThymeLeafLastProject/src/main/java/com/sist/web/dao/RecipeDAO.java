package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.Recipe2;
import java.util.*;
@Repository
public interface RecipeDAO extends JpaRepository<Recipe2, Integer>{
	// JPQL / 일반 SQL => nativeQuery = true
	// => 조인 / 서브쿼리 
    @Query(value="SELECT no,title,poster,chef,hit "
    	  +"FROM recipe2 ORDER BY no ASC "
    	  +"LIMIT 0,12",nativeQuery = true)
    public List<Recipe2> recipeMainData();
    
    // 찾기 
    public Recipe2 findByNo(int no); // 메소드로 SQL문장 생성 
    // findByNo , findByTitle => where no   , where title...
    // findByNoAndTitle  => where no and title
    // findByNameLike => where name LIKE
    
    // 목록 출력 
    @Query(value="SELECT no,title,poster,chef,hit "
    	  +"FROM recipe2 ORDER BY no ASC "
    	  +"LIMIT :start,20",nativeQuery = true)
    public List<Recipe2> recipeListData(@Param("start") int start);
    
    @Query(value="SELECT COUNT(*) FROM recipe2",nativeQuery = true)
    public int recipeRowCount();
}
