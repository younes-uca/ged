import {BaseDto} from 'app/zynerator/dto/BaseDto.model';

import {AcessShareDto} from 'app/controller/model/AcessShare.model';
import {GroupeDto} from 'app/controller/model/Groupe.model';
import {DocumentDto} from 'app/controller/model/Document.model';

export class DocumentPartageGroupeDto extends BaseDto{

   public dateShare: Date;

    public document: DocumentDto ;
    public groupe: GroupeDto ;
    public acessShare: AcessShareDto ;


    constructor() {
        super();

        this.dateShare = null;
        this.document = new DocumentDto() ;
        this.groupe = new GroupeDto() ;
        this.acessShare = new AcessShareDto() ;

        }

}
