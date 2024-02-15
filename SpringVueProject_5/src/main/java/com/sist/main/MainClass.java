package com.sist.main;

import java.io.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.FileWriteMode;

import lombok.Data;

class Movie
{
	private String title,start,star,learning_time,content;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getStar() {
		return star;
	}

	public void setStar(String star) {
		this.star = star;
	}

	public String getLearning_time() {
		return learning_time;
	}

	public void setLearning_time(String learning_time) {
		this.learning_time = learning_time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Movie(String title, String start, String star, String learning_time, String content) {
		super();
		this.title = title;
		this.start = start;
		this.star = star;
		this.learning_time = learning_time;
		this.content = content;
	}
	public Movie() {}
}
class Recipe{
	private int no;
	private String title,poster,chef,link;
    
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getChef() {
		return chef;
	}

	public void setChef(String chef) {
		this.chef = chef;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. WebDriver와 ChromeDriver 설정
				// 프로젝트 폴더 기준으로 chromedirver.exe 파일의 위치를 작성
				System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
			
				for(int j=1;j<=5411;j++)
				{
				System.out.println(j+"페이지==============================");
				// 2. 웹 페이지 접속
				String baseUrl = "https://www.10000recipe.com/recipe/list.html?order=reco&page="+j;
				// String searchTerm = "Java";
				// String url = baseUrl + "/wiki/" + searchTerm;
				
				driver.get(baseUrl);
				
				
				// 3. 데이터 추출
				   ArrayList<Movie> movie_data = new ArrayList<>();
				
				   WebElement movie_container = driver.findElement(By.cssSelector(".common_sp_list_ul"));

				   List<WebElement> movie_links = movie_container.findElements(By.cssSelector(".common_sp_list_li"));
				//System.out.println("갯수:"+movie_links.size());
				//for(int i= 0; i < movie_links.size(); i++) {
					//String link = movie_links.get(i).getAttribute("href");
					// links.add(link);
					//driver.get(link);
					
					driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
					
					List<WebElement> links = driver.findElements(By.cssSelector(".common_sp_link"));
					List<WebElement> posters = driver.findElements(By.cssSelector("img[src*=\"/recipe/\"]"));
					List<WebElement> chefs = driver.findElements(By.cssSelector(".common_sp_caption_rv_name a"));
					List<WebElement> titles = driver.findElements(By.cssSelector(".common_sp_caption_tit"));
					RecipeDAO dao=new RecipeDAO();
					int k=1;
					for(int i=0;i<links.size();i++)
					{
						 //System.out.println(links.get(i).getAttribute("href"));
						 //System.out.println(posters.get(i).getAttribute("src"));
						 //System.out.println(chefs.get(i).getText());
						 //System.out.println(titles.get(i).getText());
						 //System.out.println("====================================");
						try
						{
						 Recipe re=new Recipe(); 
						 re.setNo(i+1);
						 re.setTitle(titles.get(i).getText()); 
						 re.setPoster(posters.get(i).getAttribute("src"));
						 re.setChef(chefs.get(i).getText());
						 
						 re.setLink(links.get(i).getAttribute("href"));
						 dao.recipeInsert(re);
						 System.out.println("k="+k);
						 k++;
							/*
							 * String s="no,title,poster,chef,link\n"; try { FileWriter fw=new
							 * FileWriter("c:\\springDev\\recipe.csv",true);
							 * s=re.getNo()+","+re.getTitle()+","+re.getPoster()+","+re.getChef()+","+re.
							 * getLink()+"\n"; fw.write(s); fw.close(); }catch(Exception ex) {}
							 */
						}catch(Exception e) {}
					}
					/*
					 * Recipe re=new Recipe(); re.setTitle(title); re.setPoster(poster);
					 * re.setChef(chef); re.setLink(link);
					 */
					
					//System.out.println(title);
					//System.out.println(poster);
					//System.out.println(chef);
					//System.out.println(link);
					//movie_data.add(movie);
				
					//driver.navigate().back();
					// System.out.println(link);
				//}
				
				
				// 4. 파일저장
		        // 파일에 데이터 쓰기
		        /*String fileName = "output.csv";
		        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"))) {
		            for (int i=0; i<movie_data.size(); i++) {
		            	writer.write((i+1)+";");
		            	writer.write(movie_data.get(i).getTitle()+";");
		                writer.write(movie_data.get(i).getStar()+";");
		                writer.write(movie_data.get(i).getLearning_time()+";");
		                writer.write(movie_data.get(i).getStart()+";");
		                writer.write(movie_data.get(i).getContent().replace("\n","」"));
		                writer.newLine();
		            }
		            String currentDir = System.getProperty("user.dir");
		            System.out.println("파일 저장 디렉토리: " + currentDir);
		            System.out.println("파일에 데이터를 성공적으로 저장했습니다.");
		        } catch (IOException e) {
		            e.printStackTrace();
		        }*/
				}	
				System.out.println("저장 완료!!");
				// 5. WebDriver 종료
				driver.quit();
			}
			

	}
