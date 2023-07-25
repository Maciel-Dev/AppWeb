import axios from "axios";
import Publication from "@/model/Publication";

const URL_API_PERFIL = "http://localhost:8082/api/auth/perfil";

// export function getAllProjects(){
//     let retObject = null;
//      axios
//         .get(URL_API_PUBLICATIONS + "get")
//         .then((response => {
//             retObject = response.data;
//         }))
//     return retObject;
// }

export function getPerfil(id){
    let date = new Date().toString();
    return axios.get(URL_API_PERFIL + "/get/" + id);
}

export function createPerfil(perfil){
    return axios.post(URL_API_PERFIL + "/post", {
        biography: perfil.bio,
        gender: perfil.gen,
        fkUser: perfil.id
    })
}
