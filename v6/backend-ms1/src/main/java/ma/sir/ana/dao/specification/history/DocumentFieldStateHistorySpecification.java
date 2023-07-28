package  ma.sir.ana.dao.specification.history;

import ma.sir.ana.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ana.dao.criteria.history.DocumentFieldStateHistoryCriteria;
import ma.sir.ana.bean.history.DocumentFieldStateHistory;


public class DocumentFieldStateHistorySpecification extends AbstractHistorySpecification<DocumentFieldStateHistoryCriteria, DocumentFieldStateHistory> {

    public DocumentFieldStateHistorySpecification(DocumentFieldStateHistoryCriteria criteria) {
        super(criteria);
    }

    public DocumentFieldStateHistorySpecification(DocumentFieldStateHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
