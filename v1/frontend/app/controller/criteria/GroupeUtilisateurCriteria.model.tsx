import {BaseCriteria} from '../../zynerator/criteria/BaseCriteria.model';

import {GroupeCriteria} from 'GroupeCriteria.model';
import {UtilisateurCriteria} from 'UtilisateurCriteria.model';




export class GroupeUtilisateurCriteria  extends  BaseCriteria {


    public id: number;

  public groupe: GroupeCriteria ;
  public groupes: Array<GroupeCriteria> ;
  public utilisateur: UtilisateurCriteria ;
  public utilisateurs: Array<UtilisateurCriteria> ;


}
