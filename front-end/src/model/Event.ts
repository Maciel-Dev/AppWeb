import Publication from "@/model/Publication";

export default class Event extends Publication{

    constructor(id, data, description, title, type) {
        super(id, data, description, title, type);
    }

}