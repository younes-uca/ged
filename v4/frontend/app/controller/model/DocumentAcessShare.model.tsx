import {BaseDto} from 'app/zynerator/dto/BaseDto.model';

import {AcessShareDto} from 'app/controller/model/AcessShare.model';
import {DocumentDto} from 'app/controller/model/Document.model';

export class DocumentAcessShareDto extends BaseDto{

    public document: DocumentDto ;
    public acessShare: AcessShareDto ;


    constructor() {
        super();

        this.document = new DocumentDto() ;
        this.acessShare = new AcessShareDto() ;

        }

}
