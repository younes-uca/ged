package  ma.sir.ged.dao.specification.history;

import ma.sir.ged.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ged.dao.criteria.history.AcessShareHistoryCriteria;
import ma.sir.ged.bean.history.AcessShareHistory;


public class AcessShareHistorySpecification extends AbstractHistorySpecification<AcessShareHistoryCriteria, AcessShareHistory> {

    public AcessShareHistorySpecification(AcessShareHistoryCriteria criteria) {
        super(criteria);
    }

    public AcessShareHistorySpecification(AcessShareHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
