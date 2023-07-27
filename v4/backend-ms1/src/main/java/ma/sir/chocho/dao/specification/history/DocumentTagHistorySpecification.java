package  ma.sir.chocho.dao.specification.history;

import ma.sir.chocho.zynerator.specification.AbstractHistorySpecification;
import ma.sir.chocho.dao.criteria.history.DocumentTagHistoryCriteria;
import ma.sir.chocho.bean.history.DocumentTagHistory;


public class DocumentTagHistorySpecification extends AbstractHistorySpecification<DocumentTagHistoryCriteria, DocumentTagHistory> {

    public DocumentTagHistorySpecification(DocumentTagHistoryCriteria criteria) {
        super(criteria);
    }

    public DocumentTagHistorySpecification(DocumentTagHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
