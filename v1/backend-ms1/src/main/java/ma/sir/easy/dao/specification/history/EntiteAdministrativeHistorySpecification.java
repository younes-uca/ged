package  ma.sir.easy.dao.specification.history;

import ma.sir.easy.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easy.dao.criteria.history.EntiteAdministrativeHistoryCriteria;
import ma.sir.easy.bean.history.EntiteAdministrativeHistory;


public class EntiteAdministrativeHistorySpecification extends AbstractHistorySpecification<EntiteAdministrativeHistoryCriteria, EntiteAdministrativeHistory> {

    public EntiteAdministrativeHistorySpecification(EntiteAdministrativeHistoryCriteria criteria) {
        super(criteria);
    }

    public EntiteAdministrativeHistorySpecification(EntiteAdministrativeHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
