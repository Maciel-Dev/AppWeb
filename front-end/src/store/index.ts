import { createStore } from "vuex";
import axios from "axios";

export default createStore({
    state: {
        user: {
            id: "",
            name: "",
            email: "",
            token: "",
            img_profile: "",
            img_blob: ""
        },
        publication: [{
            id: "",
            title: "",
            description: ""
        }],
        send: false
    },
    getters: {
        getUser (state){
            return state.user;
        },
        getEmailUser(state){
          return state.user.email;
        },
        getImg (state){
            return state.user.img_blob;
        },
        getPublications (state){
            return state.publication;
        },
        getPublicationsLength(state){
            return state.publication.length;
        },
        getPubSend(state){
            return state.send
        }

    },
    actions: {},
    mutations: {
        setUser(state, user){
            state.user.id = user.id;
            state.user.name = user.firstname;
            state.user.email = user.email;
            state.user.img_profile = user.img_profile;
            state.user.token = user.token;
        },
        setPublication(state, publicationItem){
            state.publication.unshift(publicationItem);
        },
        setPubSend(state, bool){
            state.send = bool;
        }
    }
})