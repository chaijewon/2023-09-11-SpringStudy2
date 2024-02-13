package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("freeboard/")
// front = router
public class BoardController {
   @GetMapping("list.do")
   public String freeboard_list()
   {
	   return "freeboard/list";
   }
   @GetMapping("insert.do")
   public String freeboard_insert()
   {
	   return "freeboard/insert";
   }
   
}
