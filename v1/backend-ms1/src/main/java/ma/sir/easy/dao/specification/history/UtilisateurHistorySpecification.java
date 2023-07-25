package  ma.sir.easy.dao.specification.history;

import ma.sir.easy.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easy.dao.criteria.history.UtilisateurHistoryCriteria;
import ma.sir.easy.bean.history.UtilisateurHistory;


public class UtilisateurHistorySpecification extends AbstractHistorySpecification<UtilisateurHistoryCriteria, UtilisateurHistory> {

    public UtilisateurHistorySpecification(UtilisateurHistoryCriteria criteria) {
        super(criteria);
    }

    public UtilisateurHistorySpecification(UtilisateurHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
