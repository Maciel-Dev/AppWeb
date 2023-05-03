import axios from "axios";
import app from "@/App.vue";

// URL API LOGIN
// Ao realizar TUNNEL, alterar apenas a URL para teste em outros dispositivos
// const URL_API_LOGIN = "https://e32d-2804-14d-b086-4529-d171-8cfb-4e28-4460.ngrok-free.app/api/auth/"
const URL_API_LOGIN = "http://localhost:8082/api/auth/";


export async function login(user){
    return await axios
            .post(URL_API_LOGIN + "authenticate", {
                email: user.email,
                password: user.password
            })
}

export async function register(user){
    console.log(user);
    return await axios
        .post(URL_API_LOGIN + "register", {
            "firstname": user.firstName,
            "lastname": user.lastName,
            "email": user.email,
            "password": user.password,
            "file": user.file_image
        })
}

export async function logout(){
    return await axios.post(URL_API_LOGIN + "logout");
}