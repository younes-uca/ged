import {BaseCriteria} from 'app/zynerator/criteria/BaseCriteria.model';

import {AcessShareCriteria} from './AcessShareCriteria.model';
import {GroupeCriteria} from './GroupeCriteria.model';
import {DocumentCriteria} from './DocumentCriteria.model';




export class DocumentPartageGroupeCriteria  extends  BaseCriteria {

    public id: number;

    public dateShare: Date;
    public dateShareFrom: Date;
    public dateShareTo: Date;
  public document: DocumentCriteria ;
  public documents: Array<DocumentCriteria> ;
  public groupe: GroupeCriteria ;
  public groupes: Array<GroupeCriteria> ;
  public acessShare: AcessShareCriteria ;
  public acessShares: Array<AcessShareCriteria> ;

    constructor() {
        super();
        this.dateShare = null;
        this.dateShareFrom  = null;
        this.dateShareTo = null;
        this.document = new DocumentCriteria() ;
        this.documents = new Array<DocumentCriteria>() ;
        this.groupe = new GroupeCriteria() ;
        this.groupes = new Array<GroupeCriteria>() ;
        this.acessShare = new AcessShareCriteria() ;
        this.acessShares = new Array<AcessShareCriteria>() ;
    }

}
