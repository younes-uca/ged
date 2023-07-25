import {BaseDto} from '../../zynerator/dto/BaseDto.model';


export class UtilisateurDto extends BaseDto{

    public constructor() {
        super();
        this.email = "";
        this.name = "";
    }

    public email: string;
    public name: string;

}
