package  ma.sir.ana.dao.specification.history;

import ma.sir.ana.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ana.dao.criteria.history.DocumentManagementUtilisateurHistoryCriteria;
import ma.sir.ana.bean.history.DocumentManagementUtilisateurHistory;


public class DocumentManagementUtilisateurHistorySpecification extends AbstractHistorySpecification<DocumentManagementUtilisateurHistoryCriteria, DocumentManagementUtilisateurHistory> {

    public DocumentManagementUtilisateurHistorySpecification(DocumentManagementUtilisateurHistoryCriteria criteria) {
        super(criteria);
    }

    public DocumentManagementUtilisateurHistorySpecification(DocumentManagementUtilisateurHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
