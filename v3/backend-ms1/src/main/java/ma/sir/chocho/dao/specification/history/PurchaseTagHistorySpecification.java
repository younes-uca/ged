package  ma.sir.chocho.dao.specification.history;

import ma.sir.chocho.zynerator.specification.AbstractHistorySpecification;
import ma.sir.chocho.dao.criteria.history.PurchaseTagHistoryCriteria;
import ma.sir.chocho.bean.history.PurchaseTagHistory;


public class PurchaseTagHistorySpecification extends AbstractHistorySpecification<PurchaseTagHistoryCriteria, PurchaseTagHistory> {

    public PurchaseTagHistorySpecification(PurchaseTagHistoryCriteria criteria) {
        super(criteria);
    }

    public PurchaseTagHistorySpecification(PurchaseTagHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
