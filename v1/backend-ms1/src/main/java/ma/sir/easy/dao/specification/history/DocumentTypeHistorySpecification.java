package  ma.sir.easy.dao.specification.history;

import ma.sir.easy.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easy.dao.criteria.history.DocumentTypeHistoryCriteria;
import ma.sir.easy.bean.history.DocumentTypeHistory;


public class DocumentTypeHistorySpecification extends AbstractHistorySpecification<DocumentTypeHistoryCriteria, DocumentTypeHistory> {

    public DocumentTypeHistorySpecification(DocumentTypeHistoryCriteria criteria) {
        super(criteria);
    }

    public DocumentTypeHistorySpecification(DocumentTypeHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
