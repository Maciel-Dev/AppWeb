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
    getters: {
        getUser (state){
            return state.user;
        }
    },
    actions: {},
    mutations: {
        setUser(state, user){
            state.user.name = user.firstName;
            state.user.email = user.email;
            state.user.token = user.token;
        }
    }
})