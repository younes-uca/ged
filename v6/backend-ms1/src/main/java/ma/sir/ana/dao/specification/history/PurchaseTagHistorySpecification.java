package  ma.sir.ana.dao.specification.history;

import ma.sir.ana.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ana.dao.criteria.history.PurchaseTagHistoryCriteria;
import ma.sir.ana.bean.history.PurchaseTagHistory;


public class PurchaseTagHistorySpecification extends AbstractHistorySpecification<PurchaseTagHistoryCriteria, PurchaseTagHistory> {

    public PurchaseTagHistorySpecification(PurchaseTagHistoryCriteria criteria) {
        super(criteria);
    }

    public PurchaseTagHistorySpecification(PurchaseTagHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
