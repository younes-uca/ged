package  ma.sir.ana.dao.specification.history;

import ma.sir.ana.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ana.dao.criteria.history.DocumentAcessShareHistoryCriteria;
import ma.sir.ana.bean.history.DocumentAcessShareHistory;


public class DocumentAcessShareHistorySpecification extends AbstractHistorySpecification<DocumentAcessShareHistoryCriteria, DocumentAcessShareHistory> {

    public DocumentAcessShareHistorySpecification(DocumentAcessShareHistoryCriteria criteria) {
        super(criteria);
    }

    public DocumentAcessShareHistorySpecification(DocumentAcessShareHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
