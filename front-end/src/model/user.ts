export default class User{
    firstName = "";
    lastName = "";
    email = "";
    password = "";
    token = "";
    constructor(firstName, lastName, email, senha, token) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = senha;
        this.token = token;

    }
}