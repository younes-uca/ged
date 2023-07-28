import {BaseCriteria} from 'app/zynerator/criteria/BaseCriteria.model';





export class ClientCategoryCriteria  extends  BaseCriteria {

    public id: number;

    public reference: string;
    public referenceLike: string;
    public code: string;
    public codeLike: string;
     public socialIndex: null | number;
     public socialIndexMin: null | number;
     public socialIndexMax: null | number;

    constructor() {
        super();
        this.reference = '';
        this.referenceLike = '';
        this.code = '';
        this.codeLike = '';
        this.socialIndex = null;
        this.socialIndexMin = null;
        this.socialIndexMax = null;
    }

}
