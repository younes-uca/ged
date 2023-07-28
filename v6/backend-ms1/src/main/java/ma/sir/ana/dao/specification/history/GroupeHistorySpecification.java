package  ma.sir.ana.dao.specification.history;

import ma.sir.ana.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ana.dao.criteria.history.GroupeHistoryCriteria;
import ma.sir.ana.bean.history.GroupeHistory;


public class GroupeHistorySpecification extends AbstractHistorySpecification<GroupeHistoryCriteria, GroupeHistory> {

    public GroupeHistorySpecification(GroupeHistoryCriteria criteria) {
        super(criteria);
    }

    public GroupeHistorySpecification(GroupeHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
