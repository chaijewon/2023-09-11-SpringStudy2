package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class MemberDAO {
   @Autowired
   private MemberMapper mapper;
   
   public int memberIdCount(String userid)
   {
	   return mapper.memberIdCount(userid);
   }
   public void memberInsert(MemberVO vo)
   {
	   mapper.memberInsert(vo);
   }
}
