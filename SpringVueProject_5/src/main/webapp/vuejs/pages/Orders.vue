<template>
  <div class="order">
    <div class="container">
      <table class="table table-bordered">
        <thead>
        <tr>
          <th>번호</th>
          <th>주문자명</th>
          <th>주소</th>
          <th>결제 수단</th>
          <th>구입 항목</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="(order, idx) in state.orders" :key="idx">
          <td>{{ state.orders.length - idx }}</td>
          <td>{{ order.name }}</td>
          <td>{{ order.address }}</td>
          <td>{{ order.payment }}</td>
          <td>
            <div v-for="(i, idx2) in order.items" :key="idx2">{{ i.name }}</div>
          </td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import lib from "@/scripts/lib";
import {reactive} from "vue";

export default {
  setup() {
    const state = reactive({
      orders: []
    })

    axios.get('/api/orders').then(({data}) => {
      state.orders = [];

      for (let d of data) {
        if (d.items) {
          d.items = JSON.parse(d.items);
        }
        state.orders.push(d)
      }
    })

    return {state, lib}
  }
}
</script>

<style scoped>

</style>