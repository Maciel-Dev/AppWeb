import { createStore } from "vuex";
import axios from "axios";

export default createStore({
    state: {
        user: {
            name: "",
            email: "",
            token: "",
            img_profile: ""
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
            state.user.name = user.firstname;
            state.user.email = user.email;
            state.user.img_profile = user.img_profile;
            state.user.token = user.token;
        }
    }
})