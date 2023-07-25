import {BaseDto} from '../../zynerator/dto/BaseDto.model';

import {ClientCategoryDto} from '../../controller/model/ClientCategory.model';

export class ClientDto extends BaseDto{

    public fullName: string;

    public email: string;

    public clientCategory: ClientCategoryDto ;


    constructor() {
    super();

        fullName = '';
        email = '';
        clientCategory = new ClientCategoryDto() ;

        }

}
