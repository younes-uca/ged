package  ma.sir.easy.dao.specification.history;

import ma.sir.easy.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easy.dao.criteria.history.AcessManagementHistoryCriteria;
import ma.sir.easy.bean.history.AcessManagementHistory;


public class AcessManagementHistorySpecification extends AbstractHistorySpecification<AcessManagementHistoryCriteria, AcessManagementHistory> {

    public AcessManagementHistorySpecification(AcessManagementHistoryCriteria criteria) {
        super(criteria);
    }

    public AcessManagementHistorySpecification(AcessManagementHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
