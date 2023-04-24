import { createStore } from "vuex";
import axios from "axios";

export default createStore({
    state: {
        user: {
            name: "",
            email: "",
            token: "",
            authority: ""
        }
    },
    getters: {},
    actions: {},
    mutations: {
        setUser(state, token){
            state.user.token = token;
        }
    }
})