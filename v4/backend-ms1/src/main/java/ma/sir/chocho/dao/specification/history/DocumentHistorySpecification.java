package  ma.sir.chocho.dao.specification.history;

import ma.sir.chocho.zynerator.specification.AbstractHistorySpecification;
import ma.sir.chocho.dao.criteria.history.DocumentHistoryCriteria;
import ma.sir.chocho.bean.history.DocumentHistory;


public class DocumentHistorySpecification extends AbstractHistorySpecification<DocumentHistoryCriteria, DocumentHistory> {

    public DocumentHistorySpecification(DocumentHistoryCriteria criteria) {
        super(criteria);
    }

    public DocumentHistorySpecification(DocumentHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
