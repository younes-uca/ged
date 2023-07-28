package ma.sir.ana.service.facade.admin;

import java.util.List;
import ma.sir.ana.bean.core.PurchaseTag;
import ma.sir.ana.dao.criteria.core.PurchaseTagCriteria;
import ma.sir.ana.dao.criteria.history.PurchaseTagHistoryCriteria;
import ma.sir.ana.zynerator.service.IService;


public interface PurchaseTagAdminService extends  IService<PurchaseTag,PurchaseTagCriteria, PurchaseTagHistoryCriteria>  {

    List<PurchaseTag> findByPurchaseId(Long id);
    int deleteByPurchaseId(Long id);
    List<PurchaseTag> findByTagId(Long id);
    int deleteByTagId(Long id);



}
