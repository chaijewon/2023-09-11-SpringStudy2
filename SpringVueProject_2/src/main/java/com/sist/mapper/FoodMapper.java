package com.sist.mapper;
import java.util.*;
import com.sist.dao.*;
import org.apache.ibatis.annotations.Select;
public interface FoodMapper {
  @Select("SELECT fno,name,poster "
		 +"FROM food_menu_house "
		 +"WHERE fno BETWEEN 108 AND 127 "
		 +"ORDER BY fno")
  public List<FoodVO> foodListData();
  /*
   *   private int fno;
       private double score;
       private String poster,name,type,address,phone,theme,price,time,seat;
   */
  @Select("SELECT fno,name,poster,score,type,address,theme,price,time,seat "
		 +"FROM food_menu_house "
		 +"WHERE fno=#{fno}")
  public FoodVO foodDetailData(int fno);
}
