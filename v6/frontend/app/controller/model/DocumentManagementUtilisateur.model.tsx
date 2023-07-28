import {BaseDto} from 'app/zynerator/dto/BaseDto.model';

import {AcessManagementDto} from 'app/controller/model/AcessManagement.model';
import {DocumentDto} from 'app/controller/model/Document.model';
import {UtilisateurDto} from 'app/controller/model/Utilisateur.model';

export class DocumentManagementUtilisateurDto extends BaseDto{

   public dateManagement: Date;

    public document: DocumentDto ;
    public utilisateur: UtilisateurDto ;
    public acessManagement: AcessManagementDto ;


    constructor() {
        super();

        this.dateManagement = null;
        this.document = new DocumentDto() ;
        this.utilisateur = new UtilisateurDto() ;
        this.acessManagement = new AcessManagementDto() ;

        }

}
