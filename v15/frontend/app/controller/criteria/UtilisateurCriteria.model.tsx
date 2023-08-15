import {BaseCriteria} from 'app/zynerator/criteria/BaseCriteria.model';

import {EntiteAdministrativeCriteria} from './EntiteAdministrativeCriteria.model';
import {GenderCriteria} from './GenderCriteria.model';




export class UtilisateurCriteria  extends  BaseCriteria {

    public id: number;

    public email: string;
    public emailLike: string;
    public telephone: string;
    public telephoneLike: string;
    public nom: string;
    public nomLike: string;
    public prenom: string;
    public prenomLike: string;
    public dateNaissance: Date;
    public dateNaissanceFrom: Date;
    public dateNaissanceTo: Date;
  public gender: GenderCriteria ;
  public genders: Array<GenderCriteria> ;
  public entiteAdministrative: EntiteAdministrativeCriteria ;
  public entiteAdministratives: Array<EntiteAdministrativeCriteria> ;

    constructor() {
        super();
        this.email = '';
        this.emailLike = '';
        this.telephone = '';
        this.telephoneLike = '';
        this.nom = '';
        this.nomLike = '';
        this.prenom = '';
        this.prenomLike = '';
        this.dateNaissance = null;
        this.dateNaissanceFrom  = null;
        this.dateNaissanceTo = null;
        this.gender ;
        this.genders = new Array<GenderCriteria>() ;
        this.entiteAdministrative ;
        this.entiteAdministratives = new Array<EntiteAdministrativeCriteria>() ;
    }

}
