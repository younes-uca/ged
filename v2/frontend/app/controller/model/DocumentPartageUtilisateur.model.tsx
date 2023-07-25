import {BaseDto} from '../../zynerator/dto/BaseDto.model';

import {AcessShareDto} from '../../controller/model/AcessShare.model';
import {DocumentDto} from '../../controller/model/Document.model';
import {UtilisateurDto} from '../../controller/model/Utilisateur.model';

export class DocumentPartageUtilisateurDto extends BaseDto{

   public dateShare: Date;

    public document: DocumentDto ;
    public utilisateur: UtilisateurDto ;
    public acessShare: AcessShareDto ;


    constructor() {
    super();

        dateShare = null;
        document = new DocumentDto() ;
        utilisateur = new UtilisateurDto() ;
        acessShare = new AcessShareDto() ;

        }

}
