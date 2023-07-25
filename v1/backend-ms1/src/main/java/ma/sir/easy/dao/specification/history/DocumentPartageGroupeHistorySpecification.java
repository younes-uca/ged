package  ma.sir.easy.dao.specification.history;

import ma.sir.easy.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easy.dao.criteria.history.DocumentPartageGroupeHistoryCriteria;
import ma.sir.easy.bean.history.DocumentPartageGroupeHistory;


public class DocumentPartageGroupeHistorySpecification extends AbstractHistorySpecification<DocumentPartageGroupeHistoryCriteria, DocumentPartageGroupeHistory> {

    public DocumentPartageGroupeHistorySpecification(DocumentPartageGroupeHistoryCriteria criteria) {
        super(criteria);
    }

    public DocumentPartageGroupeHistorySpecification(DocumentPartageGroupeHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
