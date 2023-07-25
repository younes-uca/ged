package  ma.sir.easy.dao.specification.history;

import ma.sir.easy.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easy.dao.criteria.history.GroupeHistoryCriteria;
import ma.sir.easy.bean.history.GroupeHistory;


public class GroupeHistorySpecification extends AbstractHistorySpecification<GroupeHistoryCriteria, GroupeHistory> {

    public GroupeHistorySpecification(GroupeHistoryCriteria criteria) {
        super(criteria);
    }

    public GroupeHistorySpecification(GroupeHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
