import {BaseCriteria} from 'app/zynerator/criteria/BaseCriteria.model';

import {GroupeCriteria} from './GroupeCriteria.model';
import {UtilisateurCriteria} from './UtilisateurCriteria.model';




export class GroupeUtilisateurCriteria  extends  BaseCriteria {

    public id: number;

  public groupe: GroupeCriteria ;
  public groupes: Array<GroupeCriteria> ;
  public utilisateur: UtilisateurCriteria ;
  public utilisateurs: Array<UtilisateurCriteria> ;

    constructor() {
        super();
        this.groupe = new GroupeCriteria() ;
        this.groupes = new Array<GroupeCriteria>() ;
        this.utilisateur = new UtilisateurCriteria() ;
        this.utilisateurs = new Array<UtilisateurCriteria>() ;
    }

}
