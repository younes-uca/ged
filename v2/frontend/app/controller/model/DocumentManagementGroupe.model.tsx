import {BaseDto} from '../../zynerator/dto/BaseDto.model';

import {GroupeDto} from '../../controller/model/Groupe.model';
import {AcessManagementDto} from '../../controller/model/AcessManagement.model';
import {DocumentDto} from '../../controller/model/Document.model';

export class DocumentManagementGroupeDto extends BaseDto{

   public dateManagement: Date;

    public document: DocumentDto ;
    public groupe: GroupeDto ;
    public acessManagement: AcessManagementDto ;


    constructor() {
    super();

        dateManagement = null;
        document = new DocumentDto() ;
        groupe = new GroupeDto() ;
        acessManagement = new AcessManagementDto() ;

        }

}
