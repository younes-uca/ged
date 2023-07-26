package ma.sir.chocho.service.facade.admin;

import java.util.List;
import ma.sir.chocho.bean.core.PurchaseItem;
import ma.sir.chocho.dao.criteria.core.PurchaseItemCriteria;
import ma.sir.chocho.dao.criteria.history.PurchaseItemHistoryCriteria;
import ma.sir.chocho.zynerator.service.IService;


public interface PurchaseItemAdminService extends  IService<PurchaseItem,PurchaseItemCriteria, PurchaseItemHistoryCriteria>  {

    List<PurchaseItem> findByProductId(Long id);
    int deleteByProductId(Long id);
    List<PurchaseItem> findByPurchaseId(Long id);
    int deleteByPurchaseId(Long id);



}
