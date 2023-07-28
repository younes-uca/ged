package  ma.sir.ana.dao.specification.history;

import ma.sir.ana.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ana.dao.criteria.history.AcessShareHistoryCriteria;
import ma.sir.ana.bean.history.AcessShareHistory;


public class AcessShareHistorySpecification extends AbstractHistorySpecification<AcessShareHistoryCriteria, AcessShareHistory> {

    public AcessShareHistorySpecification(AcessShareHistoryCriteria criteria) {
        super(criteria);
    }

    public AcessShareHistorySpecification(AcessShareHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
