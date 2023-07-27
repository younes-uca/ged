package  ma.sir.chocho.dao.specification.history;

import ma.sir.chocho.zynerator.specification.AbstractHistorySpecification;
import ma.sir.chocho.dao.criteria.history.DocumentAcessShareHistoryCriteria;
import ma.sir.chocho.bean.history.DocumentAcessShareHistory;


public class DocumentAcessShareHistorySpecification extends AbstractHistorySpecification<DocumentAcessShareHistoryCriteria, DocumentAcessShareHistory> {

    public DocumentAcessShareHistorySpecification(DocumentAcessShareHistoryCriteria criteria) {
        super(criteria);
    }

    public DocumentAcessShareHistorySpecification(DocumentAcessShareHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
