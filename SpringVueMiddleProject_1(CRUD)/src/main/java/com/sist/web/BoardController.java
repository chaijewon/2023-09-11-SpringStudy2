package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.vo.BoardVO;

@Controller // 화면 변경 => forward (request전송)/ sendRedirect(재호출)
//                        경로명/파일명            redirect:.do => request를 초기화
public class BoardController {
   @GetMapping("board/list.do")
   public String board_list()
   {
	   
	   return "board/list";
   }
   @GetMapping("board/insert.do")
   public String board_insert()
   {
	   return "board/insert";
   }
   
}
