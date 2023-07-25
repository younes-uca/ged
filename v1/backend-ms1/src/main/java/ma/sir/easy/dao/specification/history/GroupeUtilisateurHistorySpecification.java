package  ma.sir.easy.dao.specification.history;

import ma.sir.easy.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easy.dao.criteria.history.GroupeUtilisateurHistoryCriteria;
import ma.sir.easy.bean.history.GroupeUtilisateurHistory;


public class GroupeUtilisateurHistorySpecification extends AbstractHistorySpecification<GroupeUtilisateurHistoryCriteria, GroupeUtilisateurHistory> {

    public GroupeUtilisateurHistorySpecification(GroupeUtilisateurHistoryCriteria criteria) {
        super(criteria);
    }

    public GroupeUtilisateurHistorySpecification(GroupeUtilisateurHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
