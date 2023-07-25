import {BaseCriteria} from '../../zynerator/criteria/BaseCriteria.model';





export class ClientCategoryCriteria  extends  BaseCriteria {

    public id: number;

    public reference: string;
    public referenceLike: string;
    public code: string;
    public codeLike: string;

    constructor() {
        super();
        reference = '';
        referenceLike = '';
        code = '';
        codeLike = '';
    }

}
