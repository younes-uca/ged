package  ma.sir.easy.dao.specification.history;

import ma.sir.easy.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easy.dao.criteria.history.DocumentManagementGroupeHistoryCriteria;
import ma.sir.easy.bean.history.DocumentManagementGroupeHistory;


public class DocumentManagementGroupeHistorySpecification extends AbstractHistorySpecification<DocumentManagementGroupeHistoryCriteria, DocumentManagementGroupeHistory> {

    public DocumentManagementGroupeHistorySpecification(DocumentManagementGroupeHistoryCriteria criteria) {
        super(criteria);
    }

    public DocumentManagementGroupeHistorySpecification(DocumentManagementGroupeHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
