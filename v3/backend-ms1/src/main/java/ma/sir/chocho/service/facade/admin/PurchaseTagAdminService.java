package ma.sir.chocho.service.facade.admin;

import java.util.List;
import ma.sir.chocho.bean.core.PurchaseTag;
import ma.sir.chocho.dao.criteria.core.PurchaseTagCriteria;
import ma.sir.chocho.dao.criteria.history.PurchaseTagHistoryCriteria;
import ma.sir.chocho.zynerator.service.IService;


public interface PurchaseTagAdminService extends  IService<PurchaseTag,PurchaseTagCriteria, PurchaseTagHistoryCriteria>  {

    List<PurchaseTag> findByPurchaseId(Long id);
    int deleteByPurchaseId(Long id);
    List<PurchaseTag> findByTagId(Long id);
    int deleteByTagId(Long id);



}
