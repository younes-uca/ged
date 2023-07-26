package  ma.sir.chocho.dao.specification.history;

import ma.sir.chocho.zynerator.specification.AbstractHistorySpecification;
import ma.sir.chocho.dao.criteria.history.AcessShareHistoryCriteria;
import ma.sir.chocho.bean.history.AcessShareHistory;


public class AcessShareHistorySpecification extends AbstractHistorySpecification<AcessShareHistoryCriteria, AcessShareHistory> {

    public AcessShareHistorySpecification(AcessShareHistoryCriteria criteria) {
        super(criteria);
    }

    public AcessShareHistorySpecification(AcessShareHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
