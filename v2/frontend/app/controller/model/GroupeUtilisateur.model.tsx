import {BaseDto} from 'app/zynerator/dto/BaseDto.model';

import {GroupeDto} from 'app/controller/model/Groupe.model';
import {UtilisateurDto} from 'app/controller/model/Utilisateur.model';

export class GroupeUtilisateurDto extends BaseDto{

    public groupe: GroupeDto ;
    public utilisateur: UtilisateurDto ;


    constructor() {
        super();

        this.groupe = new GroupeDto() ;
        this.utilisateur = new UtilisateurDto() ;

        }

}
