import {BaseDto} from '../../zynerator/dto/BaseDto.model';

import {GroupeUtilisateurDto} from '../../controller/model/GroupeUtilisateur.model';
import {UtilisateurDto} from '../../controller/model/Utilisateur.model';

export class GroupeDto extends BaseDto{

    public code: string;

    public libelle: string;

    public utilisateur: UtilisateurDto ;
     public groupeUtilisateurs: Array<GroupeUtilisateurDto>;


    constructor() {
    super();

        code = '';
        libelle = '';
        utilisateur = new UtilisateurDto() ;
        groupeUtilisateurs = new Array<GroupeUtilisateurDto>();

        }

}
