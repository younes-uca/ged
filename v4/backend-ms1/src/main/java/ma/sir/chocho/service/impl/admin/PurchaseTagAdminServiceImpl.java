package ma.sir.chocho.service.impl.admin;

import ma.sir.chocho.bean.core.PurchaseTag;
import ma.sir.chocho.bean.history.PurchaseTagHistory;
import ma.sir.chocho.dao.criteria.core.PurchaseTagCriteria;
import ma.sir.chocho.dao.criteria.history.PurchaseTagHistoryCriteria;
import ma.sir.chocho.dao.facade.core.PurchaseTagDao;
import ma.sir.chocho.dao.facade.history.PurchaseTagHistoryDao;
import ma.sir.chocho.dao.specification.core.PurchaseTagSpecification;
import ma.sir.chocho.service.facade.admin.PurchaseTagAdminService;
import ma.sir.chocho.zynerator.service.AbstractServiceImpl;
import ma.sir.chocho.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.chocho.service.facade.admin.PurchaseAdminService ;
import ma.sir.chocho.service.facade.admin.TagAdminService ;



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
    private PurchaseAdminService purchaseService ;
    @Autowired
    private TagAdminService tagService ;

    public PurchaseTagAdminServiceImpl(PurchaseTagDao dao, PurchaseTagHistoryDao historyDao) {
        super(dao, historyDao);
    }

}