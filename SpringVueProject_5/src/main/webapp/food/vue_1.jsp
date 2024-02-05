<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<!--  Fonts and icons     -->
<link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,600,700,800" rel="stylesheet">
<link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
    
    <!-- bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

<style type="text/css">
.container{
  margin-top: 50px;
}
.row{
  margin: 0px auto;
  width: 960px;
}
</style>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
  <div class="container">
   <div class="row">
     <card title="Custom Card" :content="cardMessage" :buttonText="더보기" @click="btnClick"></card>
   </div>
  </div>
  <script>
    const Card={
    		props:{
    			title:String,
    			content:String,
    			buttonText:String
    		},
    		template:`<div class="card" style="width:150px;margin:auto">
    		         <img src="https://recipe1.ezmember.co.kr/cache/recipe/2024/01/15/539c7609af6d9b9c3bac23ac745db9951_m.jpg">
    		         <div class="card-body">
    		          <h5 class="card-title">{{title}}</h5>
    		          <p class="card-text">{{content}}</p>
    		          <input type=button class="btn btn-primary" value="click">
    		         </div>
    		        </div>` 
    }
    let app=Vue.createApp({
    	components:{
    		'card':Card
    	},
    	data(){
    		return {
    			cardMessage:"Hello",
    			btitle:"더보기"
    		}
    	},
    	methods:{
    		btnClick(){
    			alert("Hello!!")
    		}
    	}
    }).mount('.container')
  </script>
</body>
</html>