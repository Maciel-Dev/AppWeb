import axios from "axios";

export async function setAuthHeader(token) {
    axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
}