import {BaseDto} from '../../zynerator/dto/BaseDto.model';

import {AcessShareDto} from '../../controller/model/AcessShare.model';
import {DocumentDto} from '../../controller/model/Document.model';

export class DocumentAcessShareDto extends BaseDto{

    public document: DocumentDto ;
    public acessShare: AcessShareDto ;


    constructor() {
    super();

        document = new DocumentDto() ;
        acessShare = new AcessShareDto() ;

        }

}
