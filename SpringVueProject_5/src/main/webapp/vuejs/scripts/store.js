import { createStore } from 'vuex'

// vuex : 전역으로 상태를 관리
const store = createStore({
    state () {
        return {
            account:{
                id: 0
            }
        }
    },
    mutations: {
        setAccount(state, payload){
            state.account.id = payload;
        }
    }
})

export default store;