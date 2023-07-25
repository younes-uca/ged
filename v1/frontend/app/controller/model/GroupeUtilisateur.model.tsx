import {BaseDto} from '../../zynerator/dto/BaseDto.model';

import {GroupeDto} from '../../controller/model/Groupe.model';
import {UtilisateurDto} from '../../controller/model/Utilisateur.model';

export class GroupeUtilisateurDto extends BaseDto{



    public groupe: GroupeDto ;
    public utilisateur: UtilisateurDto ;

}
