import axios from 'axios';

const API_URL = 'http://localhost:8082/api/auth/';

class AuthService{
    login(user: { username: any; password: any; }){
        return axios
            .post(API_URL + 'signin', {
                username: user.username,
                password: user.password
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

    register(user: { username: any; email: any; password: any; }){
        return axios
            .post(API_URL+'signup', {
                username: user.username,
                email: user.email,
                password: user.password
            })
    }
}

export default new AuthService();