import {BaseCriteria} from '../../zynerator/criteria/BaseCriteria.model';

import {AcessShareCriteria} from 'AcessShareCriteria.model';
import {DocumentCriteria} from 'DocumentCriteria.model';
import {UtilisateurCriteria} from 'UtilisateurCriteria.model';




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
        dateShare = null;
        dateShareFrom  = null;
        dateShareTo = null;
        document = new DocumentCriteria() ;
        public documents = new Array<DocumentCriteria>() ;
        utilisateur = new UtilisateurCriteria() ;
        public utilisateurs = new Array<UtilisateurCriteria>() ;
        acessShare = new AcessShareCriteria() ;
        public acessShares = new Array<AcessShareCriteria>() ;
    }

}
