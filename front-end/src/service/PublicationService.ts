import axios from "axios";

const URL_API_PUBLICATIONS = "http://localhost:8082/api/auth/projects/";

export async function getAllProjects(){
    return axios
        .get(URL_API_PUBLICATIONS + "get");
}