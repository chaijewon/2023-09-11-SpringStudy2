const pagination={
    	 props:['page_list'],
    	 template:`<ul class="pagination">
				    <li v-if="page_list.startPage>1"><a style="cursor: pointer;" @click="$parent.prev()">&laquo</a></li>
				    <li v-for="i in $parent.range($parent.startPage,$parent.endPage)" :class="i===page_list.curpage?'active':''"><a style="cursor: pointer;" @click="$parent.pageChange(i)">{{i}}</a></li>
				    <li v-if="page_list.endPage<page_list.totalpage"><a style="cursor: pointer;" @click="$parent.next()">&raquo</a></li>
				  </ul>`,
		methods:{
			
		}
    }