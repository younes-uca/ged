package  ma.sir.ana.dao.specification.history;

import ma.sir.ana.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ana.dao.criteria.history.DocumentFieldHistoryCriteria;
import ma.sir.ana.bean.history.DocumentFieldHistory;


public class DocumentFieldHistorySpecification extends AbstractHistorySpecification<DocumentFieldHistoryCriteria, DocumentFieldHistory> {

    public DocumentFieldHistorySpecification(DocumentFieldHistoryCriteria criteria) {
        super(criteria);
    }

    public DocumentFieldHistorySpecification(DocumentFieldHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
