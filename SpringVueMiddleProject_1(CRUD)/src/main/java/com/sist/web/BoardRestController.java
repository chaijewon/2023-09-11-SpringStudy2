package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.*;
import com.sist.vo.*;
// 자바스크립트와 연동 => 데이터를 받아서 처리후에 결과값 전송 => Rest => GET/POST/PUT/DELETE
// @ResponseBody => 변경 
@RestController
public class BoardRestController {
  @Autowired
  private BoardDAO dao;
  
  @GetMapping(value="board/list_vue.do",produces = "text/plain;charset=UTF-8")
  public String board_list(int page) throws Exception
  {
	  int rowSize=10;
	  int start=(rowSize*page)-(rowSize-1);
	  int end=rowSize*page;
	  List<BoardVO> list=dao.boardListData(start, end);
	  ObjectMapper mapper=new ObjectMapper();
	  String json=mapper.writeValueAsString(list);//jacksion
	  return json;
  }
  @GetMapping(value = "board/page_vue.do",produces = "text/plain;charset=UTF-8")
  public String board_page(int page) throws Exception
  {
	  Map map=new HashMap();
	  int totalpage=dao.boardTotalPage();
	  map.put("curpage", page);
	  map.put("totalpage", totalpage);
	  ObjectMapper mapper=new ObjectMapper();
	  String json=mapper.writeValueAsString(map);
	  return json;
  }
  
  @PostMapping(value="board/insert_ok.do",produces = "text/plain;charset=UTF-8")
  public void board_insert_ok(BoardVO vo)
  {
      dao.boardInsert(vo);	  
  }
  //{"":"","":""} JSONObject 
  /*
   *   @RestController
   *   class A
   *   {
   *      @GetMapping()
   *      public List<FoodVO> listdata()
   *      {
   *          List<FoodVO> list=dao.getList()
   *          return list;
   *      }
   *   }
   */
  @GetMapping(value="board/detail_vue.do",produces = "text/plain;charset=UTF-8")
  public String board_detail(int no) throws Exception
  {
	  BoardVO vo=dao.boardDetailData(no);
	  ObjectMapper mapper=new ObjectMapper();
	  String json=mapper.writeValueAsString(vo);
	  System.out.println(json);
	  return json;
  }
  
  @GetMapping(value="board/update_vue.do",produces = "text/plain;charset=UTF-8")
  public String board_update(int no) throws Exception
  {
	  BoardVO vo=dao.boardUpdateData(no);
	  ObjectMapper mapper=new ObjectMapper();
	  String json=mapper.writeValueAsString(vo);
	  return json;
  }
  
  @PostMapping(value="board/update_ok.do",produces = "text/plain;charset=UTF-8")
  public String board_update_ok(BoardVO vo)
  {
	  String result=dao.boardUpdate(vo);
	  return result;
  }
}







