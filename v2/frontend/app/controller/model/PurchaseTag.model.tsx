import {BaseDto} from '../../zynerator/dto/BaseDto.model';

import {PurchaseDto} from '../../controller/model/Purchase.model';
import {TagDto} from '../../controller/model/Tag.model';

export class PurchaseTagDto extends BaseDto{

    public purchase: PurchaseDto ;
    public tag: TagDto ;


    constructor() {
    super();

        purchase = new PurchaseDto() ;
        tag = new TagDto() ;

        }

}
