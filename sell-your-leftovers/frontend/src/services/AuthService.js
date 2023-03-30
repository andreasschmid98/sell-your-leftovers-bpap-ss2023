import axios from "axios";

const AUTH_API_BASE_URL = 'http://localhost:8080/api/auth';


class AuthService {

    login(loginRequest){
        return axios.post(AUTH_API_BASE_URL + "/login", loginRequest);
    }

    register(registerRequest){
        return axios.post(AUTH_API_BASE_URL + "/register", registerRequest);
    }

}

export default new AuthService();