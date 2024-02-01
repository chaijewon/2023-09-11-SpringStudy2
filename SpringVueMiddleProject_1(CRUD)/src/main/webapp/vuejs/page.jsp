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
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
   <div class="container">
     <div class="row">
       <template>
		  <div class="overflow-auto">
		    <b-pagination
		      v-model="currentPage"
		      :total-rows="rows"
		      :per-page="perPage"
		      aria-controls="my-table"
		    ></b-pagination>
		
		    <p class="mt-3">Current Page: {{ currentPage }}</p>
		
		    <b-table
		      id="my-table"
		      :items="items"
		      :per-page="perPage"
		      :current-page="currentPage"
		      small
		    ></b-table>
		  </div>
		</template>
     </div>
   </div>
   <script>
     let app=Vue.createApp({
    	 data() {
    	      return {
    	        perPage: 3,
    	        currentPage: 1,
    	        items: [
    	          { id: 1, first_name: 'Fred', last_name: 'Flintstone' },
    	          { id: 2, first_name: 'Wilma', last_name: 'Flintstone' },
    	          { id: 3, first_name: 'Barney', last_name: 'Rubble' },
    	          { id: 4, first_name: 'Betty', last_name: 'Rubble' },
    	          { id: 5, first_name: 'Pebbles', last_name: 'Flintstone' },
    	          { id: 6, first_name: 'Bamm Bamm', last_name: 'Rubble' },
    	          { id: 7, first_name: 'The Great', last_name: 'Gazzoo' },
    	          { id: 8, first_name: 'Rockhead', last_name: 'Slate' },
    	          { id: 9, first_name: 'Pearl', last_name: 'Slaghoople' }
    	        ]
    	      }
    	    },
    	    computed: {
    	      rows() {
    	        return this.items.length
    	      }
    	    }
    	  
     }).mount('.container')
   </script>
</body>
</html>