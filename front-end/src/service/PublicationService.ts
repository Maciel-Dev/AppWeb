import axios from "axios";

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
    return axios.post(URL_API_PUBLICATIONS + publication.type.toString().toLowerCase() + "/post", {
        Event: publication
    })
}