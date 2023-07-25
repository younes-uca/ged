package ma.sir.ged.service.facade.admin;

import java.util.List;
import ma.sir.ged.bean.core.PurchaseTag;
import ma.sir.ged.dao.criteria.core.PurchaseTagCriteria;
import ma.sir.ged.dao.criteria.history.PurchaseTagHistoryCriteria;
import ma.sir.ged.zynerator.service.IService;


public interface PurchaseTagAdminService extends  IService<PurchaseTag,PurchaseTagCriteria, PurchaseTagHistoryCriteria>  {

    List<PurchaseTag> findByPurchaseId(Long id);
    int deleteByPurchaseId(Long id);
    List<PurchaseTag> findByTagId(Long id);
    int deleteByTagId(Long id);



}
