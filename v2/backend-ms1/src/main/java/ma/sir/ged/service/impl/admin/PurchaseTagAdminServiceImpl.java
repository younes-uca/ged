package ma.sir.ged.service.impl.admin;

import ma.sir.ged.bean.core.PurchaseTag;
import ma.sir.ged.bean.history.PurchaseTagHistory;
import ma.sir.ged.dao.criteria.core.PurchaseTagCriteria;
import ma.sir.ged.dao.criteria.history.PurchaseTagHistoryCriteria;
import ma.sir.ged.dao.facade.core.PurchaseTagDao;
import ma.sir.ged.dao.facade.history.PurchaseTagHistoryDao;
import ma.sir.ged.dao.specification.core.PurchaseTagSpecification;
import ma.sir.ged.service.facade.admin.PurchaseTagAdminService;
import ma.sir.ged.zynerator.service.AbstractServiceImpl;
import ma.sir.ged.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.ged.service.facade.admin.TagAdminService ;
import ma.sir.ged.service.facade.admin.PurchaseAdminService ;



import java.util.List;
@Service
public class PurchaseTagAdminServiceImpl extends AbstractServiceImpl<PurchaseTag,PurchaseTagHistory, PurchaseTagCriteria, PurchaseTagHistoryCriteria, PurchaseTagDao,
PurchaseTagHistoryDao> implements PurchaseTagAdminService {




    public List<PurchaseTag> findByPurchaseId(Long id){
        return dao.findByPurchaseId(id);
    }
    public int deleteByPurchaseId(Long id){
        return dao.deleteByPurchaseId(id);
    }
    public List<PurchaseTag> findByTagId(Long id){
        return dao.findByTagId(id);
    }
    public int deleteByTagId(Long id){
        return dao.deleteByTagId(id);
    }




    public void configure() {
        super.configure(PurchaseTag.class,PurchaseTagHistory.class, PurchaseTagHistoryCriteria.class, PurchaseTagSpecification.class);
    }

    @Autowired
    private TagAdminService tagService ;
    @Autowired
    private PurchaseAdminService purchaseService ;

    public PurchaseTagAdminServiceImpl(PurchaseTagDao dao, PurchaseTagHistoryDao historyDao) {
        super(dao, historyDao);
    }

}