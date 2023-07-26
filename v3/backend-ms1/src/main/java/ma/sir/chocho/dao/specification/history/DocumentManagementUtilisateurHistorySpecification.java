package  ma.sir.chocho.dao.specification.history;

import ma.sir.chocho.zynerator.specification.AbstractHistorySpecification;
import ma.sir.chocho.dao.criteria.history.DocumentManagementUtilisateurHistoryCriteria;
import ma.sir.chocho.bean.history.DocumentManagementUtilisateurHistory;


public class DocumentManagementUtilisateurHistorySpecification extends AbstractHistorySpecification<DocumentManagementUtilisateurHistoryCriteria, DocumentManagementUtilisateurHistory> {

    public DocumentManagementUtilisateurHistorySpecification(DocumentManagementUtilisateurHistoryCriteria criteria) {
        super(criteria);
    }

    public DocumentManagementUtilisateurHistorySpecification(DocumentManagementUtilisateurHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
