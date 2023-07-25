import {BaseDto} from '../../zynerator/dto/BaseDto.model';


export class UtilisateurDto extends BaseDto{

    public email: string;

    public name: string;



    constructor() {
    super();

        email = '';
        name = '';

        }

}
