package  ma.sir.ana.dao.specification.history;

import ma.sir.ana.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ana.dao.criteria.history.DocumentManagementGroupeHistoryCriteria;
import ma.sir.ana.bean.history.DocumentManagementGroupeHistory;


public class DocumentManagementGroupeHistorySpecification extends AbstractHistorySpecification<DocumentManagementGroupeHistoryCriteria, DocumentManagementGroupeHistory> {

    public DocumentManagementGroupeHistorySpecification(DocumentManagementGroupeHistoryCriteria criteria) {
        super(criteria);
    }

    public DocumentManagementGroupeHistorySpecification(DocumentManagementGroupeHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
