import axios from 'axios';

const API_URL = 'http://localhost:8082/api/auth/';

class AuthService{
    login(user){
        return axios
            .post(API_URL + 'authenticated', {
                email: user.email,
                senha: user.senha
            })
            .then(response => {
                if(response.data.accessToken){
                    localStorage.setItem('user', JSON.stringify(response.data));
                }
                return response.data;
            });
    }
    logout(){
        localStorage.removeItem('user');
    }

    register(user){
        return axios
            .post(API_URL+'register', {
                email: user.email,
                password: user.password
            })
    }
}

export default new AuthService();