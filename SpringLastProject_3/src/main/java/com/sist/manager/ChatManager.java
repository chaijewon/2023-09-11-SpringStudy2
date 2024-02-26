package com.sist.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.test.web.servlet.setup.SharedHttpSessionConfigurer;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;

import lombok.Data;

import java.util.*;
@Data
class ChatVO{
	private String userId;
	private String userName;
	private Session session;
}
@ServerEndpoint(value="/chat/chat-ws",configurator = WebSokcetSessionConfigurator.class)
public class ChatManager {
   private static Map<Session,ChatVO> users=new HashMap<Session,ChatVO>();
   @OnOpen
   public void onOpen(Session session,EndpointConfig config)
   {
	   ChatVO vo=new ChatVO();
	   HttpSession hs=(HttpSession)config.getUserProperties().get("PRIVATE_HTTP_SESSION");
	   vo.setUserId((String)hs.getAttribute("userId"));
	   vo.setUserName((String)hs.getAttribute("userName"));
	   vo.setSession(session);
	   System.out.println("클라이언트 접속...:"+vo.getUserId()+"--"+vo.getUserName());
	   users.put(session,vo);
   }
   @OnMessage
   public void onMessage(String message,Session session) throws Exception
   {
	   System.out.println("수신된 메세지...:"+message+"==> 보낸사람:"+session.getId());
	   Iterator<Session> it=users.keySet().iterator();
	   while(it.hasNext())
	   {
		   Session ss=it.next();
		   ss.getBasicRemote().sendText("["+users.get(ss).getUserName()+"]"+message);
		   System.out.println(users.get(ss).getUserName()+":전송 완료!!");
	   }
	   
   }
   @OnClose
   public void onClose(Session session)
   {
	   for(int i=0;i<users.size();i++)
	   {
		   ChatVO vo=users.get(i);
		   if(vo.getSession().getId()==session.getId())
		   {
			   System.out.println("클라이언트 퇴장...:"+vo.getUserName());
			   users.remove(i);
			   
			   break;
		   }
	   }
	   
   }
}
