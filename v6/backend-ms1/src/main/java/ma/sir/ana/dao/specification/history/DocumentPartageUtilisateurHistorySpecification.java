package  ma.sir.ana.dao.specification.history;

import ma.sir.ana.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ana.dao.criteria.history.DocumentPartageUtilisateurHistoryCriteria;
import ma.sir.ana.bean.history.DocumentPartageUtilisateurHistory;


public class DocumentPartageUtilisateurHistorySpecification extends AbstractHistorySpecification<DocumentPartageUtilisateurHistoryCriteria, DocumentPartageUtilisateurHistory> {

    public DocumentPartageUtilisateurHistorySpecification(DocumentPartageUtilisateurHistoryCriteria criteria) {
        super(criteria);
    }

    public DocumentPartageUtilisateurHistorySpecification(DocumentPartageUtilisateurHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
