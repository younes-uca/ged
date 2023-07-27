package  ma.sir.chocho.dao.specification.history;

import ma.sir.chocho.zynerator.specification.AbstractHistorySpecification;
import ma.sir.chocho.dao.criteria.history.DocumentPartageUtilisateurHistoryCriteria;
import ma.sir.chocho.bean.history.DocumentPartageUtilisateurHistory;


public class DocumentPartageUtilisateurHistorySpecification extends AbstractHistorySpecification<DocumentPartageUtilisateurHistoryCriteria, DocumentPartageUtilisateurHistory> {

    public DocumentPartageUtilisateurHistorySpecification(DocumentPartageUtilisateurHistoryCriteria criteria) {
        super(criteria);
    }

    public DocumentPartageUtilisateurHistorySpecification(DocumentPartageUtilisateurHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
