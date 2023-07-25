import {BaseCriteria} from '../../zynerator/criteria/BaseCriteria.model';

import {AcessShareCriteria} from 'AcessShareCriteria.model';
import {GroupeCriteria} from 'GroupeCriteria.model';
import {DocumentCriteria} from 'DocumentCriteria.model';




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


}
