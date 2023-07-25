import {BaseCriteria} from '../../zynerator/criteria/BaseCriteria.model';





export class ProductCriteria  extends  BaseCriteria {

    public id: number;

    public code: string;
    public codeLike: string;
    public reference: string;
    public referenceLike: string;
     public purchaseCost: number;
     public purchaseCostMin: number;
     public purchaseCostMax: number;

    constructor() {
        super();
        code = '';
        codeLike = '';
        reference = '';
        referenceLike = '';
        purchaseCost = 0;
        purchaseCostMin = 0;
        purchaseCostMax = 0;
    }

}
