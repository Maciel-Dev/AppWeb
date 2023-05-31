import axios from "axios";

// URL API LOGIN
// Ao realizar TUNNEL, alterar apenas a URL para teste em outros dispositivos
// const URL_API_LOGIN = "https://e32d-2804-14d-b086-4529-d171-8cfb-4e28-4460.ngrok-free.app/api/auth/"
const URL_API_LOGIN = "http://localhost:8082/api/auth/";


export async function login(user) {
    return await axios
        .post(URL_API_LOGIN + "login", {
            username: user.email,
            password: user.password
        })
}
export async function register(request, image) {

    const config = { headers: { 'Content-Type': 'multipart/form-data' } };

    return await axios
        .post(URL_API_LOGIN + "register", request, config)
}

export async function logout() {
    return await axios.post(URL_API_LOGIN + "logout");
}

export async function loadUser(token: String){
    return await axios.post(URL_API_LOGIN + "loadUser", token);
}