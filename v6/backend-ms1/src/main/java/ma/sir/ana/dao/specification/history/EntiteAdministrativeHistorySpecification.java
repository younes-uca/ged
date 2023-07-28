package  ma.sir.ana.dao.specification.history;

import ma.sir.ana.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ana.dao.criteria.history.EntiteAdministrativeHistoryCriteria;
import ma.sir.ana.bean.history.EntiteAdministrativeHistory;


public class EntiteAdministrativeHistorySpecification extends AbstractHistorySpecification<EntiteAdministrativeHistoryCriteria, EntiteAdministrativeHistory> {

    public EntiteAdministrativeHistorySpecification(EntiteAdministrativeHistoryCriteria criteria) {
        super(criteria);
    }

    public EntiteAdministrativeHistorySpecification(EntiteAdministrativeHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
