package ma.sir.chocho.service.facade.agent;

import java.util.List;
import ma.sir.chocho.bean.core.Purchase;
import ma.sir.chocho.dao.criteria.core.PurchaseCriteria;
import ma.sir.chocho.dao.criteria.history.PurchaseHistoryCriteria;
import ma.sir.chocho.zynerator.service.IService;


public interface PurchaseAgentService extends  IService<Purchase,PurchaseCriteria, PurchaseHistoryCriteria>  {

    List<Purchase> findByClientId(Long id);
    int deleteByClientId(Long id);



}
