package  ma.sir.chocho.dao.specification.history;

import ma.sir.chocho.zynerator.specification.AbstractHistorySpecification;
import ma.sir.chocho.dao.criteria.history.DocumentPartageGroupeHistoryCriteria;
import ma.sir.chocho.bean.history.DocumentPartageGroupeHistory;


public class DocumentPartageGroupeHistorySpecification extends AbstractHistorySpecification<DocumentPartageGroupeHistoryCriteria, DocumentPartageGroupeHistory> {

    public DocumentPartageGroupeHistorySpecification(DocumentPartageGroupeHistoryCriteria criteria) {
        super(criteria);
    }

    public DocumentPartageGroupeHistorySpecification(DocumentPartageGroupeHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
