import {BaseCriteria} from '../../zynerator/criteria/BaseCriteria.model';

import {PurchaseCriteria} from 'PurchaseCriteria.model';
import {ProductCriteria} from 'ProductCriteria.model';




export class PurchaseItemCriteria  extends  BaseCriteria {

    public id: number;

     public price: number;
     public priceMin: number;
     public priceMax: number;
     public quantity: number;
     public quantityMin: number;
     public quantityMax: number;
  public product: ProductCriteria ;
  public products: Array<ProductCriteria> ;
  public purchase: PurchaseCriteria ;
  public purchases: Array<PurchaseCriteria> ;

    constructor() {
        super();
        price = 0;
        priceMin = 0;
        priceMax = 0;
        quantity = 0;
        quantityMin = 0;
        quantityMax = 0;
        product = new ProductCriteria() ;
        public products = new Array<ProductCriteria>() ;
        purchase = new PurchaseCriteria() ;
        public purchases = new Array<PurchaseCriteria>() ;
    }

}
