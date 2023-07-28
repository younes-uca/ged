package ma.sir.ana.service.impl.admin;

import ma.sir.ana.bean.core.PurchaseItem;
import ma.sir.ana.bean.history.PurchaseItemHistory;
import ma.sir.ana.dao.criteria.core.PurchaseItemCriteria;
import ma.sir.ana.dao.criteria.history.PurchaseItemHistoryCriteria;
import ma.sir.ana.dao.facade.core.PurchaseItemDao;
import ma.sir.ana.dao.facade.history.PurchaseItemHistoryDao;
import ma.sir.ana.dao.specification.core.PurchaseItemSpecification;
import ma.sir.ana.service.facade.admin.PurchaseItemAdminService;
import ma.sir.ana.zynerator.service.AbstractServiceImpl;
import ma.sir.ana.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.ana.service.facade.admin.PurchaseAdminService ;
import ma.sir.ana.service.facade.admin.ProductAdminService ;



import java.util.List;
@Service
public class PurchaseItemAdminServiceImpl extends AbstractServiceImpl<PurchaseItem,PurchaseItemHistory, PurchaseItemCriteria, PurchaseItemHistoryCriteria, PurchaseItemDao,
PurchaseItemHistoryDao> implements PurchaseItemAdminService {




    public List<PurchaseItem> findByProductId(Long id){
        return dao.findByProductId(id);
    }
    public int deleteByProductId(Long id){
        return dao.deleteByProductId(id);
    }
    public List<PurchaseItem> findByPurchaseId(Long id){
        return dao.findByPurchaseId(id);
    }
    public int deleteByPurchaseId(Long id){
        return dao.deleteByPurchaseId(id);
    }




    public void configure() {
        super.configure(PurchaseItem.class,PurchaseItemHistory.class, PurchaseItemHistoryCriteria.class, PurchaseItemSpecification.class);
    }

    @Autowired
    private PurchaseAdminService purchaseService ;
    @Autowired
    private ProductAdminService productService ;

    public PurchaseItemAdminServiceImpl(PurchaseItemDao dao, PurchaseItemHistoryDao historyDao) {
        super(dao, historyDao);
    }

}