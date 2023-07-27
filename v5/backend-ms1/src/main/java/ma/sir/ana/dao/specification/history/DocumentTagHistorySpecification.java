package  ma.sir.ana.dao.specification.history;

import ma.sir.ana.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ana.dao.criteria.history.DocumentTagHistoryCriteria;
import ma.sir.ana.bean.history.DocumentTagHistory;


public class DocumentTagHistorySpecification extends AbstractHistorySpecification<DocumentTagHistoryCriteria, DocumentTagHistory> {

    public DocumentTagHistorySpecification(DocumentTagHistoryCriteria criteria) {
        super(criteria);
    }

    public DocumentTagHistorySpecification(DocumentTagHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
