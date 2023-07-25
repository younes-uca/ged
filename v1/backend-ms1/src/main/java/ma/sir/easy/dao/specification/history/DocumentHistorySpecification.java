package  ma.sir.easy.dao.specification.history;

import ma.sir.easy.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easy.dao.criteria.history.DocumentHistoryCriteria;
import ma.sir.easy.bean.history.DocumentHistory;


public class DocumentHistorySpecification extends AbstractHistorySpecification<DocumentHistoryCriteria, DocumentHistory> {

    public DocumentHistorySpecification(DocumentHistoryCriteria criteria) {
        super(criteria);
    }

    public DocumentHistorySpecification(DocumentHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
