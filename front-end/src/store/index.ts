import { createStore } from "vuex";
import axios from "axios";

export default createStore({
    state: {
        user: {
            name: "",
            email: "",
            token: ""
        }
    },
    getters: {},
    actions: {},
    mutations: {
        setUser(state, user){
            state.user.email = user.email;
            state.user.token = user.token;
        }
    }
})