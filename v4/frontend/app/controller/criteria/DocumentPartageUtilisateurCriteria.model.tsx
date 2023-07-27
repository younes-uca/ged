import {BaseCriteria} from 'app/zynerator/criteria/BaseCriteria.model';

import {AcessShareCriteria} from './AcessShareCriteria.model';
import {DocumentCriteria} from './DocumentCriteria.model';
import {UtilisateurCriteria} from './UtilisateurCriteria.model';




export class DocumentPartageUtilisateurCriteria  extends  BaseCriteria {

    public id: number;

    public dateShare: Date;
    public dateShareFrom: Date;
    public dateShareTo: Date;
  public document: DocumentCriteria ;
  public documents: Array<DocumentCriteria> ;
  public utilisateur: UtilisateurCriteria ;
  public utilisateurs: Array<UtilisateurCriteria> ;
  public acessShare: AcessShareCriteria ;
  public acessShares: Array<AcessShareCriteria> ;

    constructor() {
        super();
        this.dateShare = null;
        this.dateShareFrom  = null;
        this.dateShareTo = null;
        this.document = new DocumentCriteria() ;
        this.documents = new Array<DocumentCriteria>() ;
        this.utilisateur = new UtilisateurCriteria() ;
        this.utilisateurs = new Array<UtilisateurCriteria>() ;
        this.acessShare = new AcessShareCriteria() ;
        this.acessShares = new Array<AcessShareCriteria>() ;
    }

}
