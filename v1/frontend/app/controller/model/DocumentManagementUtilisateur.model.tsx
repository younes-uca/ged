import {BaseDto} from '../../zynerator/dto/BaseDto.model';

import {AcessManagementDto} from '../../controller/model/AcessManagement.model';
import {DocumentDto} from '../../controller/model/Document.model';
import {UtilisateurDto} from '../../controller/model/Utilisateur.model';

export class DocumentManagementUtilisateurDto extends BaseDto{



   public dateManagement: Date;
    public dateManagementMax: string ;
    public dateManagementMin: string ;
    public document: DocumentDto ;
    public utilisateur: UtilisateurDto ;
    public acessManagement: AcessManagementDto ;

}
