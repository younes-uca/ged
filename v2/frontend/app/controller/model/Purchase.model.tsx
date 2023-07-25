import {BaseDto} from '../../zynerator/dto/BaseDto.model';

import {PurchaseTagDto} from '../../controller/model/PurchaseTag.model';
import {PurchaseItemDto} from '../../controller/model/PurchaseItem.model';
import {ClientDto} from '../../controller/model/Client.model';

export class PurchaseDto extends BaseDto{

    public reference: string;

   public purchaseDate: Date;

    public image: string;

    public total: number;

    public description: string;

    public client: ClientDto ;
     public purchaseItems: Array<PurchaseItemDto>;
     public purchaseTags: Array<PurchaseTagDto>;


    constructor() {
    super();

        reference = '';
        purchaseDate = null;
        image = '';
        total = 0;
        description = '';
        client = new ClientDto() ;
        purchaseItems = new Array<PurchaseItemDto>();
        purchaseTags = new Array<PurchaseTagDto>();

        }

}
