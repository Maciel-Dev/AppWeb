export default class Publication{
    id = null;
    data = "";
    description = "";
    title = "";
    type = null;
    constructor(id, data, description, title, type) {

        this.id = id;
        this.data = data;
        this.description = description;
        this.title = title;
        this.type = type;

    }

}