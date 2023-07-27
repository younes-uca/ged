package  ma.sir.chocho.dao.specification.history;

import ma.sir.chocho.zynerator.specification.AbstractHistorySpecification;
import ma.sir.chocho.dao.criteria.history.AcessManagementHistoryCriteria;
import ma.sir.chocho.bean.history.AcessManagementHistory;


public class AcessManagementHistorySpecification extends AbstractHistorySpecification<AcessManagementHistoryCriteria, AcessManagementHistory> {

    public AcessManagementHistorySpecification(AcessManagementHistoryCriteria criteria) {
        super(criteria);
    }

    public AcessManagementHistorySpecification(AcessManagementHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
