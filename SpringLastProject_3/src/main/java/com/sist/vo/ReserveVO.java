package com.sist.vo;
/*
 *   RNO        NOT NULL NUMBER        
FNO                 NUMBER        
USERID              VARCHAR2(20)  
RDATE      NOT NULL VARCHAR2(100) 
RTIME      NOT NULL VARCHAR2(20)  
RINWON     NOT NULL VARCHAR2(20)  
REGDATE             DATE          
RESERVE_OK          NUMBER   
 */
import java.util.*;

import lombok.Data;
@Data
public class ReserveVO {
   private int rno,fno,reserve_ok;
   private String userId,rDate,rTime,rInwon,dbday;
   private Date regdate;
   private FoodVO fvo=new FoodVO();
}
