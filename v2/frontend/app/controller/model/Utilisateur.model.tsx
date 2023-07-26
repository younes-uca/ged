import {BaseDto} from 'app/zynerator/dto/BaseDto.model';


export class UtilisateurDto extends BaseDto{

    public email: string;

    public name: string;



    constructor() {
        super();

        this.email = '';
        this.name = '';

        }

}
