import {BaseDto} from '../../zynerator/dto/BaseDto.model';

import {AcessShareDto} from '../../controller/model/AcessShare.model';
import {GroupeDto} from '../../controller/model/Groupe.model';
import {DocumentDto} from '../../controller/model/Document.model';

export class DocumentPartageGroupeDto extends BaseDto{

   public dateShare: Date;

    public document: DocumentDto ;
    public groupe: GroupeDto ;
    public acessShare: AcessShareDto ;


    constructor() {
    super();

        dateShare = null;
        document = new DocumentDto() ;
        groupe = new GroupeDto() ;
        acessShare = new AcessShareDto() ;

        }

}
