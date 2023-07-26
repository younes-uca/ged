package  ma.sir.chocho.dao.specification.history;

import ma.sir.chocho.zynerator.specification.AbstractHistorySpecification;
import ma.sir.chocho.dao.criteria.history.ClientCategoryHistoryCriteria;
import ma.sir.chocho.bean.history.ClientCategoryHistory;


public class ClientCategoryHistorySpecification extends AbstractHistorySpecification<ClientCategoryHistoryCriteria, ClientCategoryHistory> {

    public ClientCategoryHistorySpecification(ClientCategoryHistoryCriteria criteria) {
        super(criteria);
    }

    public ClientCategoryHistorySpecification(ClientCategoryHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
