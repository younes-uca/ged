package  ma.sir.ana.dao.specification.history;

import ma.sir.ana.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ana.dao.criteria.history.GroupeUtilisateurHistoryCriteria;
import ma.sir.ana.bean.history.GroupeUtilisateurHistory;


public class GroupeUtilisateurHistorySpecification extends AbstractHistorySpecification<GroupeUtilisateurHistoryCriteria, GroupeUtilisateurHistory> {

    public GroupeUtilisateurHistorySpecification(GroupeUtilisateurHistoryCriteria criteria) {
        super(criteria);
    }

    public GroupeUtilisateurHistorySpecification(GroupeUtilisateurHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
