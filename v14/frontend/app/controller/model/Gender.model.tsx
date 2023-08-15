import {BaseDto} from 'app/zynerator/dto/BaseDto.model';


export class GenderDto extends BaseDto{

    public code: string;

    public libelle: string;

    public description: string;



    constructor() {
        super();
        this.code = '';
        this.libelle = '';
        this.description = '';
        }


    getClassName() {
        return "Gender";
    }


}
