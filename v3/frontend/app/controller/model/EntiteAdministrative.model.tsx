import {BaseDto} from 'app/zynerator/dto/BaseDto.model';

import {UtilisateurDto} from 'app/controller/model/Utilisateur.model';

export class EntiteAdministrativeDto extends BaseDto{

    public code: string;

    public libelle: string;

    public utilisateur: UtilisateurDto ;


    constructor() {
        super();

        this.code = '';
        this.libelle = '';
        this.utilisateur = new UtilisateurDto() ;

        }

}
