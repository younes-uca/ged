import {BaseCriteria} from '../../zynerator/criteria/BaseCriteria.model';

import {PurchaseCriteria} from 'PurchaseCriteria.model';
import {TagCriteria} from 'TagCriteria.model';




export class PurchaseTagCriteria  extends  BaseCriteria {

    public id: number;

  public purchase: PurchaseCriteria ;
  public purchases: Array<PurchaseCriteria> ;
  public tag: TagCriteria ;
  public tags: Array<TagCriteria> ;

    constructor() {
        super();
        purchase = new PurchaseCriteria() ;
        public purchases = new Array<PurchaseCriteria>() ;
        tag = new TagCriteria() ;
        public tags = new Array<TagCriteria>() ;
    }

}
