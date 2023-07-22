export default class Publication{
    id = null;
    data = "";
    description = "";
    title = "";
    type = null;
    author = "";
    id_perfil = null;
    constructor(id, data, description, title, type, author, id_perfil) {

        this.id = id;
        this.data = data;
        this.description = description;
        this.title = title;
        this.type = type;
        this.author = author;
        this.id_perfil = id_perfil;
    }
}