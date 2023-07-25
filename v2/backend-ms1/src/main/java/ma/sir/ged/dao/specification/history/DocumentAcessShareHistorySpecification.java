package  ma.sir.ged.dao.specification.history;

import ma.sir.ged.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ged.dao.criteria.history.DocumentAcessShareHistoryCriteria;
import ma.sir.ged.bean.history.DocumentAcessShareHistory;


public class DocumentAcessShareHistorySpecification extends AbstractHistorySpecification<DocumentAcessShareHistoryCriteria, DocumentAcessShareHistory> {

    public DocumentAcessShareHistorySpecification(DocumentAcessShareHistoryCriteria criteria) {
        super(criteria);
    }

    public DocumentAcessShareHistorySpecification(DocumentAcessShareHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
