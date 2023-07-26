import {BaseCriteria} from 'app/zynerator/criteria/BaseCriteria.model';

import {PurchaseCriteria} from './PurchaseCriteria.model';
import {TagCriteria} from './TagCriteria.model';




export class PurchaseTagCriteria  extends  BaseCriteria {

    public id: number;

  public purchase: PurchaseCriteria ;
  public purchases: Array<PurchaseCriteria> ;
  public tag: TagCriteria ;
  public tags: Array<TagCriteria> ;

    constructor() {
        super();
        this.purchase = new PurchaseCriteria() ;
        this.purchases = new Array<PurchaseCriteria>() ;
        this.tag = new TagCriteria() ;
        this.tags = new Array<TagCriteria>() ;
    }

}
