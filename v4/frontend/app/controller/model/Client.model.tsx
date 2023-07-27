import {BaseDto} from 'app/zynerator/dto/BaseDto.model';

import {ClientCategoryDto} from 'app/controller/model/ClientCategory.model';

export class ClientDto extends BaseDto{

    public fullName: string;

    public email: string;

   public dateRegistration: Date;

    public nombreEnfant: null | number;

    public clientCategory: ClientCategoryDto ;


    constructor() {
        super();

        this.fullName = '';
        this.email = '';
        this.dateRegistration = null;
        this.nombreEnfant = null;
        this.clientCategory = new ClientCategoryDto() ;

        }

}
