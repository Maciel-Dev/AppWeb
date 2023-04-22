import axios from "axios";

// URL API LOGIN
const URL_API_LOGIN = "http://localhost:8082/api/auth/";

export async function login(user){
    return await axios
            .post(URL_API_LOGIN + "authenticate", {
                email: user.email,
                password: user.password
            })
}

export async function authLogin(user){

}