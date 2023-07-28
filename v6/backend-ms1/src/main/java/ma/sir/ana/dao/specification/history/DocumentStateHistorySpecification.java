package  ma.sir.ana.dao.specification.history;

import ma.sir.ana.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ana.dao.criteria.history.DocumentStateHistoryCriteria;
import ma.sir.ana.bean.history.DocumentStateHistory;


public class DocumentStateHistorySpecification extends AbstractHistorySpecification<DocumentStateHistoryCriteria, DocumentStateHistory> {

    public DocumentStateHistorySpecification(DocumentStateHistoryCriteria criteria) {
        super(criteria);
    }

    public DocumentStateHistorySpecification(DocumentStateHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
