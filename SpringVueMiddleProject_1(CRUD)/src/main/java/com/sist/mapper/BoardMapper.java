package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface BoardMapper {
   @Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit, num "
		  +"FROM (SELECT no,subject,name,regdate,hit,rownum as num "
		  +"FROM (SELECT /*+ INDEX_DESC(vueBoard vb_no_pk)*/no,subject,name,regdate,hit "
		  +"FROM vueBoard)) "
		  +"WHERE num BETWEEN #{start} AND #{end}")
   public List<BoardVO> boardListData(@Param("start") int start,@Param("end") int end);
   
   @Select("SELECT CEIL(COUNT(*)/10.0) FROM vueBoard")
   public int boardTotalPage();
   
   // INSERT , UPDATE , DELETE 
   @Insert("INSERT INTO vueBoard(no,name,subject,content,pwd) "
		  +"VALUES(vb_no_seq.nextval,#{name},#{subject},#{content},#{pwd})")
   public void boardInsert(BoardVO vo);
   
   // 상세보기 
   // 수정 
   // 삭제 
}





