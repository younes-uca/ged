import {BaseDto} from 'app/zynerator/dto/BaseDto.model';

import {GroupeDto} from 'app/controller/model/Groupe.model';
import {AcessManagementDto} from 'app/controller/model/AcessManagement.model';
import {DocumentDto} from 'app/controller/model/Document.model';

export class DocumentManagementGroupeDto extends BaseDto{

   public dateManagement: Date;

    public document: DocumentDto ;
    public groupe: GroupeDto ;
    public acessManagement: AcessManagementDto ;


    constructor() {
        super();

        this.dateManagement = null;
        this.document = new DocumentDto() ;
        this.groupe = new GroupeDto() ;
        this.acessManagement = new AcessManagementDto() ;

        }

}
