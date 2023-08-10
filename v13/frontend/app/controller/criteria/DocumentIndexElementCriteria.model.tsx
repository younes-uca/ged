import {BaseCriteria} from 'app/zynerator/criteria/BaseCriteria.model';

import {DocumentIndexElementStateCriteria} from './DocumentIndexElementStateCriteria.model';
import {IndexElementCriteria} from './IndexElementCriteria.model';
import {DocumentCriteria} from './DocumentCriteria.model';




export class DocumentIndexElementCriteria  extends  BaseCriteria {

    public id: number;

    public value: string;
    public valueLike: string;
  public indexElement: IndexElementCriteria ;
  public indexElements: Array<IndexElementCriteria> ;
  public document: DocumentCriteria ;
  public documents: Array<DocumentCriteria> ;
  public documentIndexElementState: DocumentIndexElementStateCriteria ;
  public documentIndexElementStates: Array<DocumentIndexElementStateCriteria> ;

    constructor() {
        super();
        this.value = '';
        this.valueLike = '';
        this.indexElement = new IndexElementCriteria() ;
        this.indexElements = new Array<IndexElementCriteria>() ;
        this.document = new DocumentCriteria() ;
        this.documents = new Array<DocumentCriteria>() ;
        this.documentIndexElementState = new DocumentIndexElementStateCriteria() ;
        this.documentIndexElementStates = new Array<DocumentIndexElementStateCriteria>() ;
    }

}
