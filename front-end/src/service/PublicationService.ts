import axios from "axios";
import Publication from "@/model/Publication";

const URL_API_PUBLICATIONS = "http://localhost:8082/api/auth/";

// export function getAllProjects(){
//     let retObject = null;
//      axios
//         .get(URL_API_PUBLICATIONS + "get")
//         .then((response => {
//             retObject = response.data;
//         }))
//     return retObject;
// }

export function postPublication(publication){
    let date = new Date().toString();
    return axios.post(URL_API_PUBLICATIONS + publication.type.toString().toLowerCase() + "/post", publication);
}

export function getPublications(publication){
    return axios.get(URL_API_PUBLICATIONS + publication + "/get");
}

export async function likePublication(id, publication){
    return axios
        .post(URL_API_PUBLICATIONS + "evento/like", {
            id: id
        })
}