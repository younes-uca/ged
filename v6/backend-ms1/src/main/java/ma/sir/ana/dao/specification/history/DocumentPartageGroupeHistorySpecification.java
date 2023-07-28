package  ma.sir.ana.dao.specification.history;

import ma.sir.ana.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ana.dao.criteria.history.DocumentPartageGroupeHistoryCriteria;
import ma.sir.ana.bean.history.DocumentPartageGroupeHistory;


public class DocumentPartageGroupeHistorySpecification extends AbstractHistorySpecification<DocumentPartageGroupeHistoryCriteria, DocumentPartageGroupeHistory> {

    public DocumentPartageGroupeHistorySpecification(DocumentPartageGroupeHistoryCriteria criteria) {
        super(criteria);
    }

    public DocumentPartageGroupeHistorySpecification(DocumentPartageGroupeHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
