package com.sist.dao;
import com.sist.vo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;

@Repository
public class MemberDAO {
   @Autowired
   private MemberMapper mapper;
   
   public MemberVO isLogin(String id,String pwd)
   {
	   MemberVO vo=new MemberVO();
	   // ID존재 여부 확인 
	   int count=mapper.idCount(id);
	   if(count==0) //ID가 없는 상태
	   {
		   vo.setMsg("NOID");   
	   }
	   else
	   {
		   MemberVO dbVO=mapper.isLogin(id);
		   if(pwd.equals(dbVO.getPwd()))//로그인 
		   {
			   vo.setMsg("OK");
			   // session에 저장 
			   vo.setId(dbVO.getId());
			   vo.setName(dbVO.getName());
		   }
		   else //비밀번호가 틀린상태 
		   {
			   vo.setMsg("NOPWD");
		   }
	   }
	   return vo;
   }
}
