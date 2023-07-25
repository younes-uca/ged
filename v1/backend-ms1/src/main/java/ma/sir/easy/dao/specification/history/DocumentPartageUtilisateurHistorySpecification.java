package  ma.sir.easy.dao.specification.history;

import ma.sir.easy.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easy.dao.criteria.history.DocumentPartageUtilisateurHistoryCriteria;
import ma.sir.easy.bean.history.DocumentPartageUtilisateurHistory;


public class DocumentPartageUtilisateurHistorySpecification extends AbstractHistorySpecification<DocumentPartageUtilisateurHistoryCriteria, DocumentPartageUtilisateurHistory> {

    public DocumentPartageUtilisateurHistorySpecification(DocumentPartageUtilisateurHistoryCriteria criteria) {
        super(criteria);
    }

    public DocumentPartageUtilisateurHistorySpecification(DocumentPartageUtilisateurHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
