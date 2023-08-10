import {BaseDto} from 'app/zynerator/dto/BaseDto.model';

import {DocumentIndexElementStateDto} from 'app/controller/model/DocumentIndexElementState.model';
import {IndexElementDto} from 'app/controller/model/IndexElement.model';
import {DocumentDto} from 'app/controller/model/Document.model';

export class DocumentIndexElementDto extends BaseDto{

    public value: string;

    public indexElement: IndexElementDto ;
    public document: DocumentDto ;
    public documentIndexElementState: DocumentIndexElementStateDto ;


    constructor() {
        super();
        this.value = '';
        this.indexElement = new IndexElementDto() ;
        this.document = new DocumentDto() ;
        this.documentIndexElementState = new DocumentIndexElementStateDto() ;
        }

}
