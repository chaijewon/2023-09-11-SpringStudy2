<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<style type="text/css">
a.alink:hover{
   cursor: pointer;
}
</style>
</head>
<body> 
  <div class="container" id="detailApp">
   <div class="row">
     <table class="table">
       <tr>
        <td width=30% class="text-center" rowspan="8">
          <img :src="'https://www.menupan.com'+detail_data.poster" style="width:100%">
        </td>
        <td colspan="2">
          <h3>{{detail_data.name}}&nbsp;<span style="color:orange">{{detail_data.score}}</span></h3>
        </td>
       </tr>
       <tr>
         <td width="10%">주소</td>
         <td width="60%">{{detail_data.address}}</td>
       </tr>
       <tr>
         <td width="10%">전화</td>
         <td width="60%">{{detail_data.phone}}</td>
       </tr>
       <tr>
         <td width="10%">음식종류</td>
         <td width="60%">{{detail_data.type}}</td>
       </tr>
       <tr>
         <td width="10%">가격대</td>
         <td width="60%">{{detail_data.price}}</td>
       </tr>
       <tr>
         <td width="10%">영업시간</td>
         <td width="60%">{{detail_data.time}}</td>
       </tr>
       <tr>
         <td width="10%">좌석</td>
         <td width="60%">{{detail_data.seat}}</td>
       </tr>
       <tr>
         <td width="10%">테마</td>
         <td width="60%">{{detail_data.theme}}</td>
       </tr>
       <tr>
         <td colspan="3" class="text-right">
           <a href="javascript:history.back()" class="btn btn-sm btn-danger">목록</a>
         </td>
       </tr>
     </table>
   </div>
  </div>
  <%-- component --%>
  <div class="container" id="replyApp">
   <div class="row">
     <table class="table">
       <tr>
        <td>
          <table class="table">
           <tr>
            <td class="text-left"></td>
            <td class="text-right"></td>
           </tr>
           <tr>
             <td colspan="2">
              <pre style="white-space: pre-wrap;background-color: white;border:none"></pre>
             </td>
           </tr>
          </table>
        </td>
       </tr>
     </table>
     <table class="table" v-show="sessionId!=''">
       <tr>
         <td class="text-left">
          <textarea rows="5" cols="90" style="float: left"></textarea>
          <input type=button value="댓글쓰기" style="float: left;height: 96px" class="btn-danger">
         </td>
       </tr>
     </table>
   </div>
  </div>
  <script>
  let detailApp=Vue.createApp({
	  data(){
		  return {
			  fno:${fno},
			  detail_data:{}
		  }
	  },
	  // $(function(){}) , componentDidMount() , window.onload=function(){}
	  mounted(){
		  axios.get('../food/detail_vue.do',{
			  params:{
				  fno:this.fno
			  }
		  }).then(response=>{
			  console.log(response.data)
			  this.detail_data=response.data
		  })
	  },
	  updated(){
		  
	  },
	  methods:{
		  
	  }
  }).mount('#detailApp')
  
  let replyApp=Vue.createApp({
	  data(){
		return {
			fno:${fno},
			sessionId:'${id}',
			reply_list:[],
			rno:0
		}  
	  },
	  mounted(){
		  // 시작과 동시에 댓글 읽기 
	  },
	  methods:{
		  // 수정 
		  // 삭제 
		  // 추가
	  }
  }).mount('#replyApp')
  </script>
</body>
</html>




