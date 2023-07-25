package  ma.sir.ged.dao.specification.history;

import ma.sir.ged.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ged.dao.criteria.history.PurchaseTagHistoryCriteria;
import ma.sir.ged.bean.history.PurchaseTagHistory;


public class PurchaseTagHistorySpecification extends AbstractHistorySpecification<PurchaseTagHistoryCriteria, PurchaseTagHistory> {

    public PurchaseTagHistorySpecification(PurchaseTagHistoryCriteria criteria) {
        super(criteria);
    }

    public PurchaseTagHistorySpecification(PurchaseTagHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
