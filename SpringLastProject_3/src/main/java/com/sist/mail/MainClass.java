package com.sist.mail;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String host="smtp.naver.com";
        String user="vcandjava@naver.com";
        String password="";
        Properties props=new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", 587);
        props.put("mail.smtp.auth", "true");
        
        Session session=Session.getDefaultInstance(props,new javax.mail.Authenticator() {
        	  protected PasswordAuthentication getPasswordAuthentication() {
        		  return new PasswordAuthentication(user, password);
        	  }
        });
        try
        {
        	MimeMessage message=new MimeMessage(session);
        	message.setFrom(new InternetAddress(user));
        	
        	message.setContent("안녕하세요","text/html;charset=UTF-8");
        	message.addRecipient(Message.RecipientType.TO, new InternetAddress("vcandjava@nate.com"));
        	message.setSubject("회원을 축하합니다");
        	Transport.send(message);
        	System.out.println("메일 전송 완료!!");
        }catch(Exception ex) {}
	}

}
