package  ma.sir.easy.dao.specification.history;

import ma.sir.easy.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easy.dao.criteria.history.DocumentManagementUtilisateurHistoryCriteria;
import ma.sir.easy.bean.history.DocumentManagementUtilisateurHistory;


public class DocumentManagementUtilisateurHistorySpecification extends AbstractHistorySpecification<DocumentManagementUtilisateurHistoryCriteria, DocumentManagementUtilisateurHistory> {

    public DocumentManagementUtilisateurHistorySpecification(DocumentManagementUtilisateurHistoryCriteria criteria) {
        super(criteria);
    }

    public DocumentManagementUtilisateurHistorySpecification(DocumentManagementUtilisateurHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
