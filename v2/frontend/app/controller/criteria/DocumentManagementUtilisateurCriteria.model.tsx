import {BaseCriteria} from '../../zynerator/criteria/BaseCriteria.model';

import {AcessManagementCriteria} from 'AcessManagementCriteria.model';
import {DocumentCriteria} from 'DocumentCriteria.model';
import {UtilisateurCriteria} from 'UtilisateurCriteria.model';




export class DocumentManagementUtilisateurCriteria  extends  BaseCriteria {

    public id: number;

    public dateManagement: Date;
    public dateManagementFrom: Date;
    public dateManagementTo: Date;
  public document: DocumentCriteria ;
  public documents: Array<DocumentCriteria> ;
  public utilisateur: UtilisateurCriteria ;
  public utilisateurs: Array<UtilisateurCriteria> ;
  public acessManagement: AcessManagementCriteria ;
  public acessManagements: Array<AcessManagementCriteria> ;

    constructor() {
        super();
        dateManagement = null;
        dateManagementFrom  = null;
        dateManagementTo = null;
        document = new DocumentCriteria() ;
        public documents = new Array<DocumentCriteria>() ;
        utilisateur = new UtilisateurCriteria() ;
        public utilisateurs = new Array<UtilisateurCriteria>() ;
        acessManagement = new AcessManagementCriteria() ;
        public acessManagements = new Array<AcessManagementCriteria>() ;
    }

}
