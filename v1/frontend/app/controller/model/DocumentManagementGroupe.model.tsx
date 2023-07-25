import {BaseDto} from '../../zynerator/dto/BaseDto.model';

import {GroupeDto} from '../../controller/model/Groupe.model';
import {AcessManagementDto} from '../../controller/model/AcessManagement.model';
import {DocumentDto} from '../../controller/model/Document.model';

export class DocumentManagementGroupeDto extends BaseDto{



   public dateManagement: Date;
    public dateManagementMax: string ;
    public dateManagementMin: string ;
    public document: DocumentDto ;
    public groupe: GroupeDto ;
    public acessManagement: AcessManagementDto ;

}
