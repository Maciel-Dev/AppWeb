export default class User{
    id = "";
    firstname = "";
    lastName = "";
    email = "";
    password = "";
    token = "";
    img_profile = "";
    img_blob = "";
    constructor(id, firstname, lastName, email, senha, token, img_profile, img_blob) {
        this.id = id;
        this.firstname = firstname;
        this.lastName = lastName;
        this.email = email;
        this.password = senha;
        this.token = token;
        this.img_profile = img_profile;
        this.img_blob = img_blob;
    }
}