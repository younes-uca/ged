package  ma.sir.ged.dao.specification.history;

import ma.sir.ged.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ged.dao.criteria.history.DocumentManagementGroupeHistoryCriteria;
import ma.sir.ged.bean.history.DocumentManagementGroupeHistory;


public class DocumentManagementGroupeHistorySpecification extends AbstractHistorySpecification<DocumentManagementGroupeHistoryCriteria, DocumentManagementGroupeHistory> {

    public DocumentManagementGroupeHistorySpecification(DocumentManagementGroupeHistoryCriteria criteria) {
        super(criteria);
    }

    public DocumentManagementGroupeHistorySpecification(DocumentManagementGroupeHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
