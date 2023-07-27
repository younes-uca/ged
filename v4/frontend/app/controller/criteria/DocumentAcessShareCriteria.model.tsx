import {BaseCriteria} from 'app/zynerator/criteria/BaseCriteria.model';

import {AcessShareCriteria} from './AcessShareCriteria.model';
import {DocumentCriteria} from './DocumentCriteria.model';




export class DocumentAcessShareCriteria  extends  BaseCriteria {

    public id: number;

  public document: DocumentCriteria ;
  public documents: Array<DocumentCriteria> ;
  public acessShare: AcessShareCriteria ;
  public acessShares: Array<AcessShareCriteria> ;

    constructor() {
        super();
        this.document = new DocumentCriteria() ;
        this.documents = new Array<DocumentCriteria>() ;
        this.acessShare = new AcessShareCriteria() ;
        this.acessShares = new Array<AcessShareCriteria>() ;
    }

}
