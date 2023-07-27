import {BaseDto} from 'app/zynerator/dto/BaseDto.model';


export class ProductDto extends BaseDto{

    public code: string;

    public reference: string;

    public purchaseCost: null | number;



    constructor() {
        super();

        this.code = '';
        this.reference = '';
        this.purchaseCost = null;

        }

}
