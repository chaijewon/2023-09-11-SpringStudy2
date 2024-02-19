package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import com.sist.service.*;
import com.sist.vo.*;
@Controller
public class MemberController {
    @Autowired
    private MemberService mService;
    
    @GetMapping("member/join.do")
    public String member_join()
    {
    	return "member/join";
    }
    
}
