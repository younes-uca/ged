package  ma.sir.ana.dao.specification.history;

import ma.sir.ana.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ana.dao.criteria.history.DocumentCategorieHistoryCriteria;
import ma.sir.ana.bean.history.DocumentCategorieHistory;


public class DocumentCategorieHistorySpecification extends AbstractHistorySpecification<DocumentCategorieHistoryCriteria, DocumentCategorieHistory> {

    public DocumentCategorieHistorySpecification(DocumentCategorieHistoryCriteria criteria) {
        super(criteria);
    }

    public DocumentCategorieHistorySpecification(DocumentCategorieHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
