<template>
  <div class="order">
    <div class="container">
      <div class="py-5 text-center"><h2>주문하기</h2></div>
      <div class="row">
        <div class="col-md-4 order-md-2 mb-4"><h4 class="d-flex justify-content-between align-items-center mb-3"><span
            class="text-muted">주문 정보</span><span
            class="badge badge-secondary badge-pill">{{ state.items.length }}</span></h4>
          <ul class="list-group mb-3">
            <li class="list-group-item d-flex justify-content-between lh-condensed" v-for="(i, idx) in state.items"
                :key="idx">
              <div><h6 class="my-0">{{ i.name }}</h6></div>
              <span class="text-muted">{{ lib.getNumberFormatted(i.price - i.price * i.discountPer / 100) }}</span></li>
          </ul>
          <h4 class="text-center total-price">
            {{ lib.getNumberFormatted(computedPrice) }} 원
          </h4>
        </div>
        <div class="col-md-8 order-md-1"><h4 class="mb-3">주문자 정보</h4>
          <div class="needs-validation" novalidate="">
            <div class="row"></div>
            <div class="mb-3"><label for="username">이름</label>
              <div class="input-group">
                <input type="text" class="form-control" id="username" v-model="state.form.name"
                >
                <div class="invalid-feedback" style="width:100%;"> Your username is required.</div>
              </div>
            </div>
            <div class="mb-3"><label for="address">주소</label>
              <input type="text" class="form-control" id="address" v-model="state.form.address">
            </div>
            <div class="row"></div>
            <div class="custom-control custom-checkbox"></div>
            <div class="custom-control custom-checkbox"></div>
            <hr class="mb-4">
            <h4 class="mb-3">결제 수단</h4>
            <div class="d-block my-3">
              <div class="custom-control custom-radio">
                <input id="card" name="paymentMethod" type="radio"
                       class="custom-control-input" value="card" v-model="state.form.payment"><label
                  class="custom-control-label" for="card">
                신용카드</label></div>
              <div class="custom-control custom-radio">
                <input id="bank" name="paymentMethod" type="radio" value="bank" v-model="state.form.payment"
                       class="custom-control-input"><label class="custom-control-label" for="bank"> 무통장입금</label></div>
            </div>
            <div class="row">
              <div class="col-md-6 mb-3"><label for="cc-name">카드 번호</label>
                <input type="text" class="form-control" id="cc-name" v-model="state.form.cardNumber">
                <div class="invalid-feedback"> Name on card is required</div>
              </div>
            </div>
            <div class="row"></div>
            <hr class="mb-4">
            <button class="btn btn-primary btn-lg btn-block" @click="submit()">결제하기</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import {computed, reactive} from "vue";
import axios from "axios";
import lib from "@/scripts/lib";
import router from "@/scripts/router";

export default {
  name: "Order",
  setup() {
    const state = reactive({
      items: [],
      form: {
        name: "",
        address: "",
        payment: "",
        cardNumber: "",
        items: ""
      }
    })

    const load = () => {
      axios.get('/api/cart/items').then(({data}) => {
        state.items = data;
      })
    }

    load();

    const submit = ()=>{
      const args = JSON.parse(JSON.stringify(state.form))
      args.items =JSON.stringify(state.items)
      axios.post("/api/orders", args).then(()=>{
        alert('주문완료')
        router.push({path: "/orders"})
      })
    }

    const computedPrice = computed(() => { // 데이터 값을 계산하고, 그 값을 캐시하여 성능 개선
      let result = 0;
      for (let i of state.items) {
        result += i.price - i.price * i.discountPer / 100;
      }
      return result;
    })

    return {state, lib, computedPrice, submit}
  }
}
</script>

<style scoped>

</style>