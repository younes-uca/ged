import {BaseDto} from 'app/zynerator/dto/BaseDto.model';

import {PurchaseTagDto} from 'app/controller/model/PurchaseTag.model';
import {PurchaseItemDto} from 'app/controller/model/PurchaseItem.model';
import {ClientDto} from 'app/controller/model/Client.model';

export class PurchaseDto extends BaseDto{

    public reference: string;

   public purchaseDate: Date;

    public image: string;

    public total: null | number;

    public description: string;

    public client: ClientDto ;
     public purchaseItems: Array<PurchaseItemDto>;
     public purchaseTags: Array<PurchaseTagDto>;


    constructor() {
        super();

        this.reference = '';
        this.purchaseDate = null;
        this.image = '';
        this.total = null;
        this.description = '';
        this.client = new ClientDto() ;
        this.purchaseItems = new Array<PurchaseItemDto>();
        this.purchaseTags = new Array<PurchaseTagDto>();

        }

}
