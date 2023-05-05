export default class User{
    firstname = "";
    lastName = "";
    email = "";
    password = "";
    token = "";
    img_profile = "";
    constructor(firstname, lastName, email, senha, token, img_profile) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.email = email;
        this.password = senha;
        this.token = token;
        this.img_profile = img_profile;
    }
}