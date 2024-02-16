package com.sist.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.*;
public class RecipeDetailMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RecipeDAO dao=new RecipeDAO();
		List<Recipe> rList=dao.recipeInfoData();
    	// http://www.10000recipe.com/recipe/6907454
    	int k=1;
    	for(Recipe r:rList)
    	{
	    	try
	    	{
	    		Document doc=Jsoup.connect("http://www.10000recipe.com"+r.getLink()).get();
	    		Element poster=doc.selectFirst("div.centeredcrop img");// doc.select("").get(0)
	    		
	    		Element title=doc.selectFirst("div.view2_summary h3");
	    		Element chef=doc.selectFirst("div.profile_cont p.cont_name");
	    		Element chef_poster=doc.selectFirst("div.profile_pic img");
	    		Element chef_profile=doc.selectFirst("div.profile_cont p.cont_intro");
	    		Element content=doc.selectFirst("div.view2_summary_in");
	    		Elements foodmake=doc.select("div.view_step_cont");
	    		Elements foodimg=doc.select("div[id*=stepimg] img[src*=/recipe/]");
	    		Element info1=doc.selectFirst("span.view2_summary_info1");
	    		Element info2=doc.selectFirst("span.view2_summary_info2");
	    		Element info3=doc.selectFirst("span.view2_summary_info3");
	    		Elements datas=doc.select("div#divConfirmedMaterialArea li");
	    		/*
	    		 *  <img src="https://recipe1.ezmember.co.kr/cache/recipe/2020/08/28/fdbb88682cc022c7b4a8347038d7b8b81.jpg">
	    		 */
	    		String food="";
	    		for(int i=0;i<foodmake.size();i++)
	    		{
	    			food+=(i+1)+"."+foodmake.get(i).text()+"^"+foodimg.get(i).attr("src")+"\n";
	    		}
	    		String data="";
	    		for(int i=0;i<datas.size();i++)
	    		{
	    			data+=datas.get(i).text()+",";
	    		}
	    		data=data.substring(0,data.lastIndexOf(","));
	    		
	    		RecipeDetailVO vo=new RecipeDetailVO();
	    		//System.out.println(food);
	    		vo.setPoster(poster.attr("src"));
	    		vo.setChef(chef.text());
	    		vo.setChef_poster(chef_poster.attr("src"));
	    		vo.setChef_profile(chef_profile.text());
	    		vo.setContent(content.text());
	    		vo.setFoodmake(food);
	    		vo.setTitle(title.text());
	    		vo.setInfo1(info1.text());
	    		vo.setInfo2(info2.text());
	    		vo.setInfo3(info3.text());
	    		vo.setStuff(data);
	    		vo.setNo(r.getNo());
	    		
	    		System.out.println("제목:"+vo.getTitle());
	    		System.out.println("쉐프:"+vo.getChef());
	    		System.out.println("내용:"+vo.getContent());
	    		System.out.println("조리법:"+vo.getFoodmake());
	    		System.out.println("정보1:"+vo.getInfo1());
	    		System.out.println("정보2:"+vo.getInfo2());
	    		System.out.println("정보3:"+vo.getInfo3());
	    		System.out.println("재료:"+vo.getStuff());
	    		System.out.println("k="+k);
	    		dao.recipeDetailInsert(vo);
	    		k++;
	    	}catch(Exception ex){}
    	}
	}

}
