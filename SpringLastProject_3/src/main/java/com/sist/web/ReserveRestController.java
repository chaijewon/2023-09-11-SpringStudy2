package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import javax.servlet.http.HttpSession;

import com.sist.vo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.*;
@RestController
public class ReserveRestController {
   @Autowired
   private ReserveService rService;
   
   @GetMapping(value="reserve/food_list_vue.do",produces = "text/plain;charset=UTF-8")
   public String food_list(String type) throws Exception
   {
	   List<FoodVO> list=rService.foodReserveData(type);
	   ObjectMapper mapper=new ObjectMapper();
	   String json=mapper.writeValueAsString(list);
	   return json;
   }
   @PostMapping(value="reserve/reserve_ok.do",produces = "text/plain;charset=UTF-8")
   public String reserve_ok(ReserveVO vo,HttpSession session)
   {
	   String result="no";
	   try {
		   vo.setUserId((String)session.getAttribute("userId"));
	       /*System.out.println("fno:"+vo.getFno());
	       System.out.println("date:"+vo.getRDate());
	       System.out.println("time:"+vo.getRTime());
	       System.out.println("inwon:"+vo.getRInwon());
	       System.out.println("userId:"+vo.getUserId());*/
		   rService.foodReserveInsert(vo);
	       result="yes";
	   }catch(Exception ex)
	   {
		   result="no";
	   }
	   
	   return result;
   }
   
}
