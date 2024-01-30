<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
  margin-top: 50px;
}
.row{
  margin: 0px auto;
  width: 960px;
}
.images:hover{
  cursor: pointer;
}
</style>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
  <div class="container">
    <div class="row">
     
    </div>
  </div>
  <script>
   let app=Vue.createApp({
	   data(){
		   return {
			   food_list:[],
			   curpage:1,
			   totalpage:0,
			   startPage:0,
			   endPage:0
		   }
	   },
	   mounted(){
		   axios.get("http://localhost:8080/web/food/list_vue.do",{
			   params:{
				   page:this.curpage
			   }
		   }).then(response=>{
			   console.log(response.data)
			   this.food_list=response.data;
		   })
	   }
   }).mount(".container")
  </script>
</body>
</html>