package ma.sir.ana.service.facade.admin;

import java.util.List;
import ma.sir.ana.bean.core.PurchaseItem;
import ma.sir.ana.dao.criteria.core.PurchaseItemCriteria;
import ma.sir.ana.dao.criteria.history.PurchaseItemHistoryCriteria;
import ma.sir.ana.zynerator.service.IService;


public interface PurchaseItemAdminService extends  IService<PurchaseItem,PurchaseItemCriteria, PurchaseItemHistoryCriteria>  {

    List<PurchaseItem> findByProductId(Long id);
    int deleteByProductId(Long id);
    List<PurchaseItem> findByPurchaseId(Long id);
    int deleteByPurchaseId(Long id);



}
