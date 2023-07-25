package  ma.sir.easy.dao.specification.history;

import ma.sir.easy.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easy.dao.criteria.history.DocumentTagHistoryCriteria;
import ma.sir.easy.bean.history.DocumentTagHistory;


public class DocumentTagHistorySpecification extends AbstractHistorySpecification<DocumentTagHistoryCriteria, DocumentTagHistory> {

    public DocumentTagHistorySpecification(DocumentTagHistoryCriteria criteria) {
        super(criteria);
    }

    public DocumentTagHistorySpecification(DocumentTagHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
