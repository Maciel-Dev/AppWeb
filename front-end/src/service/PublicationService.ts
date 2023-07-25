import axios from "axios";
import Publication from "@/model/Publication";

const URL_API_PUBLICATIONS = "http://localhost:8082/api/auth/";

export function postPublication(publication){
    alert(publication.get);

    const config = { headers: { 'Content-Type': 'multipart/form-data' } };

    return axios.post(URL_API_PUBLICATIONS + publication.get("type").toString().toLowerCase() + "/post", publication, config);
}

export function getPublications(){
    return axios.get(URL_API_PUBLICATIONS + "publication/get");
}

export async function likePublication(id, publication){
    return axios
        .post(URL_API_PUBLICATIONS + "evento/like", {
            id: id
        })
}