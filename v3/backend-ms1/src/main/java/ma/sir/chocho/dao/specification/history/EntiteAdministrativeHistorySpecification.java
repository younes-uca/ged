package  ma.sir.chocho.dao.specification.history;

import ma.sir.chocho.zynerator.specification.AbstractHistorySpecification;
import ma.sir.chocho.dao.criteria.history.EntiteAdministrativeHistoryCriteria;
import ma.sir.chocho.bean.history.EntiteAdministrativeHistory;


public class EntiteAdministrativeHistorySpecification extends AbstractHistorySpecification<EntiteAdministrativeHistoryCriteria, EntiteAdministrativeHistory> {

    public EntiteAdministrativeHistorySpecification(EntiteAdministrativeHistoryCriteria criteria) {
        super(criteria);
    }

    public EntiteAdministrativeHistorySpecification(EntiteAdministrativeHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
