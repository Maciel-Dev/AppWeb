const user = JSON.parse(localStorage.getItem('user')!);
const initializeUser = user ? { status: {loggedIn: true}, user} : { status: {loggedIn: false}, user: null};

export const auth = {
    namespaced: true,
    state: {
        user: [
            {id: "", name: "", email: ""}
        ]
    },
    actions: {

    },
    getters:{
        user(state){
            return state;
        }
    },
    mutations: {

    },
}