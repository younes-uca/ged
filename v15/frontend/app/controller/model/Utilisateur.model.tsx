import {BaseDto} from 'app/zynerator/dto/BaseDto.model';

import {EntiteAdministrativeDto} from 'app/controller/model/EntiteAdministrative.model';
import {GenderDto} from 'app/controller/model/Gender.model';

export class UtilisateurDto extends BaseDto{

    public email: string;

    public telephone: string;

    public nom: string;

    public prenom: string;

   public dateNaissance: Date;

    public gender: GenderDto ;
    public entiteAdministrative: EntiteAdministrativeDto ;


    constructor() {
        super();
        this.email = '';
        this.telephone = '';
        this.nom = '';
        this.prenom = '';
        this.dateNaissance = null;
        this.gender;
        this.entiteAdministrative;
        }

    getClassName() {
        return "Utilisateur";
    }
}
