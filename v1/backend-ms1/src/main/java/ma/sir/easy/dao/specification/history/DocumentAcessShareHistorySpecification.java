package  ma.sir.easy.dao.specification.history;

import ma.sir.easy.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easy.dao.criteria.history.DocumentAcessShareHistoryCriteria;
import ma.sir.easy.bean.history.DocumentAcessShareHistory;


public class DocumentAcessShareHistorySpecification extends AbstractHistorySpecification<DocumentAcessShareHistoryCriteria, DocumentAcessShareHistory> {

    public DocumentAcessShareHistorySpecification(DocumentAcessShareHistoryCriteria criteria) {
        super(criteria);
    }

    public DocumentAcessShareHistorySpecification(DocumentAcessShareHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
