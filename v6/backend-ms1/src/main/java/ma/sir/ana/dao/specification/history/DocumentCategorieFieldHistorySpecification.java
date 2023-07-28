package  ma.sir.ana.dao.specification.history;

import ma.sir.ana.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ana.dao.criteria.history.DocumentCategorieFieldHistoryCriteria;
import ma.sir.ana.bean.history.DocumentCategorieFieldHistory;


public class DocumentCategorieFieldHistorySpecification extends AbstractHistorySpecification<DocumentCategorieFieldHistoryCriteria, DocumentCategorieFieldHistory> {

    public DocumentCategorieFieldHistorySpecification(DocumentCategorieFieldHistoryCriteria criteria) {
        super(criteria);
    }

    public DocumentCategorieFieldHistorySpecification(DocumentCategorieFieldHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
