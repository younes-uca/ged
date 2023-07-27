package  ma.sir.ana.dao.specification.history;

import ma.sir.ana.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ana.dao.criteria.history.UtilisateurHistoryCriteria;
import ma.sir.ana.bean.history.UtilisateurHistory;


public class UtilisateurHistorySpecification extends AbstractHistorySpecification<UtilisateurHistoryCriteria, UtilisateurHistory> {

    public UtilisateurHistorySpecification(UtilisateurHistoryCriteria criteria) {
        super(criteria);
    }

    public UtilisateurHistorySpecification(UtilisateurHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
