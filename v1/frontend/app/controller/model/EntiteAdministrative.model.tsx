import {BaseDto} from '../../zynerator/dto/BaseDto.model';

import {UtilisateurDto} from '../../controller/model/Utilisateur.model';

export class EntiteAdministrativeDto extends BaseDto{



    public code: string;
    public libelle: string;
    public utilisateur: UtilisateurDto ;

}
