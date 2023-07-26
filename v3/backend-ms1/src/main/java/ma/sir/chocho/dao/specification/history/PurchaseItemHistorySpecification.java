package  ma.sir.chocho.dao.specification.history;

import ma.sir.chocho.zynerator.specification.AbstractHistorySpecification;
import ma.sir.chocho.dao.criteria.history.PurchaseItemHistoryCriteria;
import ma.sir.chocho.bean.history.PurchaseItemHistory;


public class PurchaseItemHistorySpecification extends AbstractHistorySpecification<PurchaseItemHistoryCriteria, PurchaseItemHistory> {

    public PurchaseItemHistorySpecification(PurchaseItemHistoryCriteria criteria) {
        super(criteria);
    }

    public PurchaseItemHistorySpecification(PurchaseItemHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
