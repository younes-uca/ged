package  ma.sir.ana.dao.specification.history;

import ma.sir.ana.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ana.dao.criteria.history.DocumentCategorieFieldRuleHistoryCriteria;
import ma.sir.ana.bean.history.DocumentCategorieFieldRuleHistory;


public class DocumentCategorieFieldRuleHistorySpecification extends AbstractHistorySpecification<DocumentCategorieFieldRuleHistoryCriteria, DocumentCategorieFieldRuleHistory> {

    public DocumentCategorieFieldRuleHistorySpecification(DocumentCategorieFieldRuleHistoryCriteria criteria) {
        super(criteria);
    }

    public DocumentCategorieFieldRuleHistorySpecification(DocumentCategorieFieldRuleHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
