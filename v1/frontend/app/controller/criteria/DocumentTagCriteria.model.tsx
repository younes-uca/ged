import {BaseCriteria} from '../../zynerator/criteria/BaseCriteria.model';

import {TagCriteria} from 'TagCriteria.model';
import {DocumentCriteria} from 'DocumentCriteria.model';




export class DocumentTagCriteria  extends  BaseCriteria {


    public id: number;

  public document: DocumentCriteria ;
  public documents: Array<DocumentCriteria> ;
  public tag: TagCriteria ;
  public tags: Array<TagCriteria> ;


}
