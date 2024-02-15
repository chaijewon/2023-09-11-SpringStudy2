package com.sist.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ChefMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RecipeDAO dao=new RecipeDAO();
		try
		{
			int k=1;
			for(int i=1;i<=40;i++)
			{
				// https://www.10000recipe.com/chef/chef_list.html?order=chef_no_follower&term=all&page=2
				Document doc=Jsoup.connect("http://www.10000recipe.com/chef/chef_list.html?order=chef_no_follower&term=all&page="+i).get();
				Elements poster=doc.select("div.list_mem3 a.mem_pic img");
				Elements chef=doc.select("div.list_cont4 a");
				Elements mem_cont1=doc.select("span.mem_cont1");
				Elements mem_cont3=doc.select("span.mem_cont3");
				Elements mem_cont7=doc.select("span.mem_cont7");
				Elements mem_cont2=doc.select("span.mem_cont2");
				
				for(int j=0;j<poster.size();j++)
				{
					try
					{
						ChefVO vo=new ChefVO();
						vo.setPoster(poster.get(j).attr("src"));
						vo.setChef(chef.get(j).text());
						String m1=mem_cont1.get(j).text();
						m1=m1.replaceAll("[^0-9]", "");
						String m2=mem_cont2.get(j).text();
						String m3=mem_cont3.get(j).text();	
						String m7=mem_cont7.get(j).text();
						m1=m1.replaceAll("[^0-9]", "");
						m2=m2.replaceAll("[^0-9]", "");
						m3=m3.replaceAll("[^0-9]", "");
						m7=m7.replaceAll("[^0-9]", "");
						vo.setMem_cont1(Integer.parseInt(m1));
						vo.setMem_cont3(Integer.parseInt(m3));
						vo.setMem_cont7(Integer.parseInt(m7));
						vo.setMem_cont2(Integer.parseInt(m2));
						System.out.println("Poster:"+vo.getPoster());
						System.out.println("Chef:"+vo.getChef());
						System.out.println("Mem-cont1:"+vo.getMem_cont1());
						System.out.println("Mem-cont3:"+vo.getMem_cont3());
						System.out.println("Mem-cont7:"+vo.getMem_cont7());
						System.out.println("Mem-cont2:"+vo.getMem_cont2());
						System.out.println("k="+k);
						System.out.println("---------------------------------------------------------");
						dao.chefInsert(vo);
					    k++;
					}catch(Exception ex){}
					//list.add(vo);
				}
			}
		}catch(Exception ex){ex.printStackTrace();}
	}

}
