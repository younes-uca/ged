import {BaseDto} from 'app/zynerator/dto/BaseDto.model';


export class ClientCategoryDto extends BaseDto{

    public reference: string;

    public code: string;

    public socialIndex: null | number;



    constructor() {
        super();

        this.reference = '';
        this.code = '';
        this.socialIndex = null;

        }

}
