package ma.sir.ana.service.facade.admin;

import java.util.List;
import ma.sir.ana.bean.core.Purchase;
import ma.sir.ana.dao.criteria.core.PurchaseCriteria;
import ma.sir.ana.dao.criteria.history.PurchaseHistoryCriteria;
import ma.sir.ana.zynerator.service.IService;


public interface PurchaseAdminService extends  IService<Purchase,PurchaseCriteria, PurchaseHistoryCriteria>  {

    List<Purchase> findByClientId(Long id);
    int deleteByClientId(Long id);



}
