package  ma.sir.easy.dao.specification.history;

import ma.sir.easy.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easy.dao.criteria.history.AcessShareHistoryCriteria;
import ma.sir.easy.bean.history.AcessShareHistory;


public class AcessShareHistorySpecification extends AbstractHistorySpecification<AcessShareHistoryCriteria, AcessShareHistory> {

    public AcessShareHistorySpecification(AcessShareHistoryCriteria criteria) {
        super(criteria);
    }

    public AcessShareHistorySpecification(AcessShareHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
