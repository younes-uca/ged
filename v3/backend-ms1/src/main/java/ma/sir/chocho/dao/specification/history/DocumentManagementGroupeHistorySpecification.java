package  ma.sir.chocho.dao.specification.history;

import ma.sir.chocho.zynerator.specification.AbstractHistorySpecification;
import ma.sir.chocho.dao.criteria.history.DocumentManagementGroupeHistoryCriteria;
import ma.sir.chocho.bean.history.DocumentManagementGroupeHistory;


public class DocumentManagementGroupeHistorySpecification extends AbstractHistorySpecification<DocumentManagementGroupeHistoryCriteria, DocumentManagementGroupeHistory> {

    public DocumentManagementGroupeHistorySpecification(DocumentManagementGroupeHistoryCriteria criteria) {
        super(criteria);
    }

    public DocumentManagementGroupeHistorySpecification(DocumentManagementGroupeHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
