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
.row {
  margin: 0px auto;
  width:960px;
}
</style>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
  <div class="container">
    <div class="row">
      <mycom></mycom>
    </div>
    <div style="height: 30px"></div>
    <div class="row">
      전송 받은 값:{{value}}
    </div>
  </div>
  <script>
    
    const myComp={
    	template:`<div>하위 컴포넌트 <button class="btn-sm btn-success" @click="$parent.sendMessage('Hello')">전송</button></div>`
    	/* methods:{
    		sendMessage(){
    			this.$emit('sendData','Hello Vue3!!')
    		}
    	} */
    }
    let app=Vue.createApp({
    	data(){
    		return {
    			value:''
    		}
    	},
    	components:{
    		'mycom':myComp
    	},
    	methods:{
    		sendMessage(val){
    			this.value=val
    		}
    	}
    }).mount('.container')
  </script>
</body>
</html>