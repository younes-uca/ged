import {BaseDto} from 'app/zynerator/dto/BaseDto.model';


export class DocumentCategorieIndexRuleDto extends BaseDto{

    public code: string;

    public libelle: string;

    public expresion: string;



    constructor() {
        super();
        this.code = '';
        this.libelle = '';
        this.expresion = '';
        }

}
