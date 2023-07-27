package  ma.sir.chocho.dao.specification.history;

import ma.sir.chocho.zynerator.specification.AbstractHistorySpecification;
import ma.sir.chocho.dao.criteria.history.DocumentTypeHistoryCriteria;
import ma.sir.chocho.bean.history.DocumentTypeHistory;


public class DocumentTypeHistorySpecification extends AbstractHistorySpecification<DocumentTypeHistoryCriteria, DocumentTypeHistory> {

    public DocumentTypeHistorySpecification(DocumentTypeHistoryCriteria criteria) {
        super(criteria);
    }

    public DocumentTypeHistorySpecification(DocumentTypeHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
