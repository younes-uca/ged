import {BaseCriteria} from 'app/zynerator/criteria/BaseCriteria.model';

import {AcessManagementCriteria} from './AcessManagementCriteria.model';
import {DocumentCriteria} from './DocumentCriteria.model';
import {UtilisateurCriteria} from './UtilisateurCriteria.model';




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
        this.dateManagement = null;
        this.dateManagementFrom  = null;
        this.dateManagementTo = null;
        this.document = new DocumentCriteria() ;
        this.documents = new Array<DocumentCriteria>() ;
        this.utilisateur = new UtilisateurCriteria() ;
        this.utilisateurs = new Array<UtilisateurCriteria>() ;
        this.acessManagement = new AcessManagementCriteria() ;
        this.acessManagements = new Array<AcessManagementCriteria>() ;
    }

}
