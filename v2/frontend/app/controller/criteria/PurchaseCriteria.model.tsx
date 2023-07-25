import {BaseCriteria} from '../../zynerator/criteria/BaseCriteria.model';

import {PurchaseTagCriteria} from 'PurchaseTagCriteria.model';
import {PurchaseItemCriteria} from 'PurchaseItemCriteria.model';
import {ClientCriteria} from 'ClientCriteria.model';




export class PurchaseCriteria  extends  BaseCriteria {

    public id: number;

    public reference: string;
    public referenceLike: string;
    public purchaseDate: Date;
    public purchaseDateFrom: Date;
    public purchaseDateTo: Date;
    public image: string;
    public imageLike: string;
     public total: number;
     public totalMin: number;
     public totalMax: number;
    public description: string;
    public descriptionLike: string;
  public client: ClientCriteria ;
  public clients: Array<ClientCriteria> ;
      public purchaseItems: Array<PurchaseItemCriteria>;
      public purchaseTags: Array<PurchaseTagCriteria>;

    constructor() {
        super();
        reference = '';
        referenceLike = '';
        purchaseDate = null;
        purchaseDateFrom  = null;
        purchaseDateTo = null;
        image = '';
        imageLike = '';
        total = 0;
        totalMin = 0;
        totalMax = 0;
        description = '';
        descriptionLike = '';
        client = new ClientCriteria() ;
        public clients = new Array<ClientCriteria>() ;
    }

}
