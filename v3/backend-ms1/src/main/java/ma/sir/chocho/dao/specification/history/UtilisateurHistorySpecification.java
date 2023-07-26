package  ma.sir.chocho.dao.specification.history;

import ma.sir.chocho.zynerator.specification.AbstractHistorySpecification;
import ma.sir.chocho.dao.criteria.history.UtilisateurHistoryCriteria;
import ma.sir.chocho.bean.history.UtilisateurHistory;


public class UtilisateurHistorySpecification extends AbstractHistorySpecification<UtilisateurHistoryCriteria, UtilisateurHistory> {

    public UtilisateurHistorySpecification(UtilisateurHistoryCriteria criteria) {
        super(criteria);
    }

    public UtilisateurHistorySpecification(UtilisateurHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
