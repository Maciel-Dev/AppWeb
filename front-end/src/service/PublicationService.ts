import axios from "axios";

const URL_API_PUBLICATIONS = "http://localhost:8082/api/auth/projects/";

export function getAllProjects(){
    let retObject = null;
     axios
        .get(URL_API_PUBLICATIONS + "get")
        .then((response => {
            retObject = response.data;
        }))
    return retObject;
}