import {BaseDto} from '../../zynerator/dto/BaseDto.model';

import {PurchaseDto} from '../../controller/model/Purchase.model';
import {ProductDto} from '../../controller/model/Product.model';

export class PurchaseItemDto extends BaseDto{

    public price: number;

    public quantity: number;

    public product: ProductDto ;
    public purchase: PurchaseDto ;


    constructor() {
    super();

        price = 0;
        quantity = 0;
        product = new ProductDto() ;
        purchase = new PurchaseDto() ;

        }

}
