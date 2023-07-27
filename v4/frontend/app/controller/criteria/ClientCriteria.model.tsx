import {BaseCriteria} from 'app/zynerator/criteria/BaseCriteria.model';

import {ClientCategoryCriteria} from './ClientCategoryCriteria.model';




export class ClientCriteria  extends  BaseCriteria {

    public id: number;

    public fullName: string;
    public fullNameLike: string;
    public email: string;
    public emailLike: string;
    public dateRegistration: Date;
    public dateRegistrationFrom: Date;
    public dateRegistrationTo: Date;
     public nombreEnfant: null | number;
     public nombreEnfantMin: null | number;
     public nombreEnfantMax: null | number;
  public clientCategory: ClientCategoryCriteria ;
  public clientCategorys: Array<ClientCategoryCriteria> ;

    constructor() {
        super();
        this.fullName = '';
        this.fullNameLike = '';
        this.email = '';
        this.emailLike = '';
        this.dateRegistration = null;
        this.dateRegistrationFrom  = null;
        this.dateRegistrationTo = null;
        this.nombreEnfant = null;
        this.nombreEnfantMin = null;
        this.nombreEnfantMax = null;
        this.clientCategory = new ClientCategoryCriteria() ;
        this.clientCategorys = new Array<ClientCategoryCriteria>() ;
    }

}
