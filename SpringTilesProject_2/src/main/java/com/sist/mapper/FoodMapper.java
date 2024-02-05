package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.FoodVO;
public interface FoodMapper {
   @Select("SELECT fno,poster,name,num "
		  +"FROM (SELECT fno,poster,name,rownum as num "
		  +"FROM (SELECT fno,poster,name "
		  +"FROM food_menu_house ORDER BY fno ASC)) "
		  +"WHERE num BETWEEN #{start} AND #{end}")
   public List<FoodVO> foodListData(@Param("start") int start,@Param("end") int end);
   
   @Select("SELECT CEIL(COUNT(*)/12.0) FROM food_menu_house")
   public int foodTotalPage();
   
   /*
    *   private int fno;
    private double score;
    private String poster,name,type,address,phone,theme,price,time,seat,sessionId;
   */
   @Select("SELECT fno,score,poster,name,type,address,theme,price,time,seat "
		  +"FROM food_menu_house "
		  +"WHERE fno=#{fno}")
   public FoodVO foodDetailData(int fno);
   // 리턴형 매개변수 => 메소드명 중복만 없으면 가능 
   //  resultType              parameterType
}
