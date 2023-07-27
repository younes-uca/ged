package  ma.sir.chocho.dao.specification.history;

import ma.sir.chocho.zynerator.specification.AbstractHistorySpecification;
import ma.sir.chocho.dao.criteria.history.GroupeUtilisateurHistoryCriteria;
import ma.sir.chocho.bean.history.GroupeUtilisateurHistory;


public class GroupeUtilisateurHistorySpecification extends AbstractHistorySpecification<GroupeUtilisateurHistoryCriteria, GroupeUtilisateurHistory> {

    public GroupeUtilisateurHistorySpecification(GroupeUtilisateurHistoryCriteria criteria) {
        super(criteria);
    }

    public GroupeUtilisateurHistorySpecification(GroupeUtilisateurHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
