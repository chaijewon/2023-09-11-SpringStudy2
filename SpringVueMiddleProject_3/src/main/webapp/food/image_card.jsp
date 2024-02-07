<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
@import url("https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700;900&display=swap");
* {
  box-sizing: border-box;
}

/*body {
  background: #fff;
  font-family: "Roboto", sans-serif;
  min-height: 100vh;
  margin: 60px 0;
  color: #0d0c0c;
  background: url(https://animal-crossing.com/assets/img/patterns/footer-dots.png) #dd7f20;
}*/

.card {
  background: #fff;
  border-radius: 8px;
  box-shadow: 0px 14px 80px rgba(34, 35, 58, 0.2);
  transition: all 300ms ease;
}
.card:hover {
  transform: translateY(-5px);
  cursor: pointer;
}
.card__container {
  max-width: 1200px;
  margin: 0 auto;
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  grid-gap: 32px 32px;
}
.card__cover {
  height: 250px;
  background-size: cover;
  background-position: center;
  border-radius: 8px 8px 0 0;
  position: relative;
}
.card__tag {
  background: #dd2020;
  display: inline-block;
  position: absolute;
  bottom: 10px;
  left: 20px;
  padding: 3px 8px;
  border-radius: 8px;
  font-size: 13px;
  font-weight: bold;
  text-transform: uppercase;
  color: #fff;
}
.card__body {
  padding: 20px;
}
.card__title {
  font-size: 25px;
  font-weight: 600;
  margin-bottom: 8px;
}
.card__desc {
  margin-bottom: 20px;
  font-size: 15px;
  color: #858484;
  line-height: 1.6;
}

.card__cover--one {
  background-image: url(https://cdn.dribbble.com/users/250235/screenshots/7885863/media/b2a6d5fb3c27de51d1c0c424296460ba.png);
}
.card__cover--two {
  background-image: url(https://cdn.dribbble.com/users/769121/screenshots/11112077/media/1445dc22a15c2590ac332fc20abaf2df.jpg);
}
.card__cover--three {
  background-image: url(https://cdn.dribbble.com/users/772985/screenshots/6034403/link_4x.png?compress=1&resize=1200x900);
}

#huck {
  max-width: 80px;
  position: fixed;
  right: 0;
  bottom: 0;
}
</style>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
  <div id="app">
    <card v-bind:food_list="food_list"/>
  </div>
  <script>
    const Card={
    	props:['food_list'],
    	template:
    		`<div class="card__container">
		    <div class="card" v-for="vo in food_list">
		      <div class="card__cover card__cover--one" :style="{backgroundImage:'url(https://www.menupan.com'+vo.poster+')'}">
		        <div class="card__tag">{{vo.price}}</div>
		      </div>
		      <div class="card__body">
		        <div class="card__title">{{vo.name}}</div>
		        <div class="card__desc">{{vo.theme}}</div>
		      </div>
		    </div>
		  </div>`,
		  
    }
    let app=Vue.createApp({
    	data(){
    		return {
    			food_list:[],
    		    curpage:1
    		}
    	},
    	mounted(){
    		axios.get('../food/list_vue.do',{
				params:{
					page:this.curpage
				}
			}).then(response=>{
				console.log(response.data)
				this.food_list=response.data
			})
    	},
    	components:{
    		'card':Card
    	}
    }).mount('#app')
  </script>
</body>
</html>