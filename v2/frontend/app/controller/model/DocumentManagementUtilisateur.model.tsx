import {BaseDto} from '../../zynerator/dto/BaseDto.model';

import {AcessManagementDto} from '../../controller/model/AcessManagement.model';
import {DocumentDto} from '../../controller/model/Document.model';
import {UtilisateurDto} from '../../controller/model/Utilisateur.model';

export class DocumentManagementUtilisateurDto extends BaseDto{

   public dateManagement: Date;

    public document: DocumentDto ;
    public utilisateur: UtilisateurDto ;
    public acessManagement: AcessManagementDto ;


    constructor() {
    super();

        dateManagement = null;
        document = new DocumentDto() ;
        utilisateur = new UtilisateurDto() ;
        acessManagement = new AcessManagementDto() ;

        }

}
