import {createStore} from "vuex";

const user = JSON.parse(localStorage.getItem('user')!);
const initializeUser = user ? { status: {loggedIn: true}, user} : { status: {loggedIn: false}, user: null};

export const auth = createStore({
    //Create model for fullfilled
    state: {
        user: [
            {id: "", name: "", email: ""}
        ]
    },
    // Create Logic to update the Store
    actions: {

    },
    // Get informations from model created on store
    getters:{
        user(state){
            return `${state}`;
        }
    },
    // Create mutations to actions call
    mutations: {

    },
})