package  ma.sir.ana.dao.specification.history;

import ma.sir.ana.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ana.dao.criteria.history.AcessManagementHistoryCriteria;
import ma.sir.ana.bean.history.AcessManagementHistory;


public class AcessManagementHistorySpecification extends AbstractHistorySpecification<AcessManagementHistoryCriteria, AcessManagementHistory> {

    public AcessManagementHistorySpecification(AcessManagementHistoryCriteria criteria) {
        super(criteria);
    }

    public AcessManagementHistorySpecification(AcessManagementHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
