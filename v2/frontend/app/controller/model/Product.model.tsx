import {BaseDto} from '../../zynerator/dto/BaseDto.model';


export class ProductDto extends BaseDto{

    public code: string;

    public reference: string;

    public purchaseCost: number;



    constructor() {
    super();

        code = '';
        reference = '';
        purchaseCost = 0;

        }

}
