package  ma.sir.ana.dao.specification.history;

import ma.sir.ana.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ana.dao.criteria.history.DocumentHistoryCriteria;
import ma.sir.ana.bean.history.DocumentHistory;


public class DocumentHistorySpecification extends AbstractHistorySpecification<DocumentHistoryCriteria, DocumentHistory> {

    public DocumentHistorySpecification(DocumentHistoryCriteria criteria) {
        super(criteria);
    }

    public DocumentHistorySpecification(DocumentHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
