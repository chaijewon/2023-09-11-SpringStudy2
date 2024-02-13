package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface FoodMapper {
  @Select("SELECT fno,poster,name,num "
		 +"FROM (SELECT fno,poster,name,rownum as num "
		 +"FROM (SELECT fno,poster,name "
		 +"FROM food_menu_house "
		 +"WHERE address LIKE '%'||#{address}||'%' "
		 +"ORDER BY fno ASC)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
  public List<FoodVO> foodFindData(Map map);
  
  @Select("SELECT CEIL(COUNT(*)/20.0) FROM food_menu_house "
		 +"WHERE address LIKE '%'||#{address}||'%'")
  public int foodFindCount(Map map);
  
  /*
   *   private int fno;
       private double score;
       private String poster,name,type,address,phone,theme,price,time,seat,sessionId;
   */
  @Select("SELECT fno,score,poster,name,type,address,phone,theme,price,time,seat "
		 +"FROM food_menu_house "
		 +"WHERE fno=#{fno}")
  public FoodVO foodDetailData(int fno);
}
