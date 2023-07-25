import {BaseCriteria} from '../../zynerator/criteria/BaseCriteria.model';

import {ClientCategoryCriteria} from 'ClientCategoryCriteria.model';




export class ClientCriteria  extends  BaseCriteria {

    public id: number;

    public fullName: string;
    public fullNameLike: string;
    public email: string;
    public emailLike: string;
  public clientCategory: ClientCategoryCriteria ;
  public clientCategorys: Array<ClientCategoryCriteria> ;

    constructor() {
        super();
        fullName = '';
        fullNameLike = '';
        email = '';
        emailLike = '';
        clientCategory = new ClientCategoryCriteria() ;
        public clientCategorys = new Array<ClientCategoryCriteria>() ;
    }

}
