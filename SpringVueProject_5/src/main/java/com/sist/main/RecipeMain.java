package com.sist.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class RecipeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int k=1;
		 RecipeDAO dao=new RecipeDAO();
	     try
	     {
	    	 for(int i=1;i<=5411;i++)
	    	 {
	    		 Document doc=Jsoup.connect("http://www.10000recipe.com/recipe/list.html?order=accuracy&page="+i).get();
	    		 Elements title=doc.select("div.common_sp_caption div.common_sp_caption_tit");
	    		 Elements poster=doc.select("img[src*=/recipe/]");
	    		 Elements chef=doc.select("div.common_sp_caption_rv_name");
	    		 Elements link=doc.select("div.common_sp_thumb a.common_sp_link");
	    		 
	    		 for(int j=0;j<title.size();j++)
	    		 {
	    			try
	    			{
		    			 Recipe vo=new Recipe();
		    			 vo.setTitle(title.get(j).text());
		    			 vo.setPoster(poster.get(j).attr("src"));
		    			 vo.setChef(chef.get(j).text());
		    			 vo.setLink(link.get(j).attr("href"));
		    			 System.out.println("번호:"+k);
		    			 System.out.println("Title:"+vo.getTitle());
		    			 System.out.println("Chef:"+vo.getChef());
		    			 System.out.println("Poster:"+vo.getPoster());
		    			 System.out.println("Link:"+vo.getLink());
		    			 System.out.println("k="+k);
		    			 
		    			 dao.recipeInsert(vo);
		    			 k++;
		    			 //Thread.sleep(100);
		    			 
	    			}catch(Exception e) {e.printStackTrace();}
	    		 }
	    	 }
	    	 System.out.println("End...");
	     }catch(Exception ex){ex.printStackTrace();}
	}

}
