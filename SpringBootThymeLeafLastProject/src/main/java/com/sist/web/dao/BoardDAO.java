package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.entity.*;
import java.util.*;
public interface BoardDAO extends JpaRepository<Board, Integer>{
   // => insert , update , delete 
   // 상세보기
   public Board findByNo(int no);
   @Query(value="SELECT no,subject,name,content,hit,regdate "
		 +"FROM Board ORDER BY no DESC "
		 +"LIMIT :start,10",nativeQuery = true)
   public List<BoardVO> boardListData(@Param("start") int start);
   
   
}
