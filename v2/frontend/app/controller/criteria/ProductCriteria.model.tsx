import {BaseCriteria} from 'app/zynerator/criteria/BaseCriteria.model';





export class ProductCriteria  extends  BaseCriteria {

    public id: number;

    public code: string;
    public codeLike: string;
    public reference: string;
    public referenceLike: string;
     public purchaseCost: null | number;
     public purchaseCostMin: null | number;
     public purchaseCostMax: null | number;

    constructor() {
        super();
        this.code = '';
        this.codeLike = '';
        this.reference = '';
        this.referenceLike = '';
        this.purchaseCost = null;
        this.purchaseCostMin = null;
        this.purchaseCostMax = null;
    }

}
