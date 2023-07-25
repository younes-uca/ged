import {BaseCriteria} from '../../zynerator/criteria/BaseCriteria.model';

import {GroupeCriteria} from 'GroupeCriteria.model';
import {AcessManagementCriteria} from 'AcessManagementCriteria.model';
import {DocumentCriteria} from 'DocumentCriteria.model';




export class DocumentManagementGroupeCriteria  extends  BaseCriteria {

    public id: number;

    public dateManagement: Date;
    public dateManagementFrom: Date;
    public dateManagementTo: Date;
  public document: DocumentCriteria ;
  public documents: Array<DocumentCriteria> ;
  public groupe: GroupeCriteria ;
  public groupes: Array<GroupeCriteria> ;
  public acessManagement: AcessManagementCriteria ;
  public acessManagements: Array<AcessManagementCriteria> ;

    constructor() {
        super();
        dateManagement = null;
        dateManagementFrom  = null;
        dateManagementTo = null;
        document = new DocumentCriteria() ;
        public documents = new Array<DocumentCriteria>() ;
        groupe = new GroupeCriteria() ;
        public groupes = new Array<GroupeCriteria>() ;
        acessManagement = new AcessManagementCriteria() ;
        public acessManagements = new Array<AcessManagementCriteria>() ;
    }

}
