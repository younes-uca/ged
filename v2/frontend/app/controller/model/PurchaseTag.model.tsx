import {BaseDto} from 'app/zynerator/dto/BaseDto.model';

import {PurchaseDto} from 'app/controller/model/Purchase.model';
import {TagDto} from 'app/controller/model/Tag.model';

export class PurchaseTagDto extends BaseDto{

    public purchase: PurchaseDto ;
    public tag: TagDto ;


    constructor() {
        super();

        this.purchase = new PurchaseDto() ;
        this.tag = new TagDto() ;

        }

}
