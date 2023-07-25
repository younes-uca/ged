import {BaseDto} from '../../zynerator/dto/BaseDto.model';


export class DocumentTypeDto extends BaseDto{

    public code: string;

    public libelle: string;



    constructor() {
    super();

        code = '';
        libelle = '';

        }

}
