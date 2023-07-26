import {BaseCriteria} from 'app/zynerator/criteria/BaseCriteria.model';





export class UtilisateurCriteria  extends  BaseCriteria {

    public id: number;

    public email: string;
    public emailLike: string;
    public name: string;
    public nameLike: string;

    constructor() {
        super();
        this.email = '';
        this.emailLike = '';
        this.name = '';
        this.nameLike = '';
    }

}
