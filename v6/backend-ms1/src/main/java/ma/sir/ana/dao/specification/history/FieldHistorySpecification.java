package  ma.sir.ana.dao.specification.history;

import ma.sir.ana.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ana.dao.criteria.history.FieldHistoryCriteria;
import ma.sir.ana.bean.history.FieldHistory;


public class FieldHistorySpecification extends AbstractHistorySpecification<FieldHistoryCriteria, FieldHistory> {

    public FieldHistorySpecification(FieldHistoryCriteria criteria) {
        super(criteria);
    }

    public FieldHistorySpecification(FieldHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
