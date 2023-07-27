package  ma.sir.chocho.dao.specification.history;

import ma.sir.chocho.zynerator.specification.AbstractHistorySpecification;
import ma.sir.chocho.dao.criteria.history.GroupeHistoryCriteria;
import ma.sir.chocho.bean.history.GroupeHistory;


public class GroupeHistorySpecification extends AbstractHistorySpecification<GroupeHistoryCriteria, GroupeHistory> {

    public GroupeHistorySpecification(GroupeHistoryCriteria criteria) {
        super(criteria);
    }

    public GroupeHistorySpecification(GroupeHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
