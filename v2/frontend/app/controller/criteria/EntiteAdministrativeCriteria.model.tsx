import {BaseCriteria} from 'app/zynerator/criteria/BaseCriteria.model';

import {UtilisateurCriteria} from './UtilisateurCriteria.model';




export class EntiteAdministrativeCriteria  extends  BaseCriteria {

    public id: number;

    public code: string;
    public codeLike: string;
    public libelle: string;
    public libelleLike: string;
  public utilisateur: UtilisateurCriteria ;
  public utilisateurs: Array<UtilisateurCriteria> ;

    constructor() {
        super();
        this.code = '';
        this.codeLike = '';
        this.libelle = '';
        this.libelleLike = '';
        this.utilisateur = new UtilisateurCriteria() ;
        this.utilisateurs = new Array<UtilisateurCriteria>() ;
    }

}
