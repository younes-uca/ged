package  ma.sir.ana.dao.specification.history;

import ma.sir.ana.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ana.dao.criteria.history.DocumentTypeHistoryCriteria;
import ma.sir.ana.bean.history.DocumentTypeHistory;


public class DocumentTypeHistorySpecification extends AbstractHistorySpecification<DocumentTypeHistoryCriteria, DocumentTypeHistory> {

    public DocumentTypeHistorySpecification(DocumentTypeHistoryCriteria criteria) {
        super(criteria);
    }

    public DocumentTypeHistorySpecification(DocumentTypeHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
