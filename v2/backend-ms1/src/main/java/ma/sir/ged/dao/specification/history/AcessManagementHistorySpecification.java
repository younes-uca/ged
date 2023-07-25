package  ma.sir.ged.dao.specification.history;

import ma.sir.ged.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ged.dao.criteria.history.AcessManagementHistoryCriteria;
import ma.sir.ged.bean.history.AcessManagementHistory;


public class AcessManagementHistorySpecification extends AbstractHistorySpecification<AcessManagementHistoryCriteria, AcessManagementHistory> {

    public AcessManagementHistorySpecification(AcessManagementHistoryCriteria criteria) {
        super(criteria);
    }

    public AcessManagementHistorySpecification(AcessManagementHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
