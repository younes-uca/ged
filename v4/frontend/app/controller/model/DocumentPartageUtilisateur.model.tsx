import {BaseDto} from 'app/zynerator/dto/BaseDto.model';

import {AcessShareDto} from 'app/controller/model/AcessShare.model';
import {DocumentDto} from 'app/controller/model/Document.model';
import {UtilisateurDto} from 'app/controller/model/Utilisateur.model';

export class DocumentPartageUtilisateurDto extends BaseDto{

   public dateShare: Date;

    public document: DocumentDto ;
    public utilisateur: UtilisateurDto ;
    public acessShare: AcessShareDto ;


    constructor() {
        super();

        this.dateShare = null;
        this.document = new DocumentDto() ;
        this.utilisateur = new UtilisateurDto() ;
        this.acessShare = new AcessShareDto() ;

        }

}
