package ma.sir.ana.service.impl.admin;

import ma.sir.ana.bean.core.Purchase;
import ma.sir.ana.bean.history.PurchaseHistory;
import ma.sir.ana.dao.criteria.core.PurchaseCriteria;
import ma.sir.ana.dao.criteria.history.PurchaseHistoryCriteria;
import ma.sir.ana.dao.facade.core.PurchaseDao;
import ma.sir.ana.dao.facade.history.PurchaseHistoryDao;
import ma.sir.ana.dao.specification.core.PurchaseSpecification;
import ma.sir.ana.service.facade.admin.PurchaseAdminService;
import ma.sir.ana.zynerator.service.AbstractServiceImpl;
import ma.sir.ana.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.sir.ana.bean.core.PurchaseItem;
import ma.sir.ana.bean.core.PurchaseTag;

import ma.sir.ana.service.facade.admin.PurchaseItemAdminService ;
import ma.sir.ana.service.facade.admin.PurchaseTagAdminService ;
import ma.sir.ana.service.facade.admin.ClientAdminService ;



import java.util.List;
@Service
public class PurchaseAdminServiceImpl extends AbstractServiceImpl<Purchase,PurchaseHistory, PurchaseCriteria, PurchaseHistoryCriteria, PurchaseDao,
PurchaseHistoryDao> implements PurchaseAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Purchase create(Purchase t) {
        super.create(t);
        if (t.getPurchaseItems() != null) {
                t.getPurchaseItems().forEach(element-> {
                    element.setPurchase(t);
                    purchaseItemService.create(element);
            });
        }
        if (t.getPurchaseTags() != null) {
                t.getPurchaseTags().forEach(element-> {
                    element.setPurchase(t);
                    purchaseTagService.create(element);
            });
        }
        return t;
    }

    public Purchase findWithAssociatedLists(Long id){
        Purchase result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setPurchaseItems(purchaseItemService.findByPurchaseId(id));
            result.setPurchaseTags(purchaseTagService.findByPurchaseId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        purchaseItemService.deleteByPurchaseId(id);
        purchaseTagService.deleteByPurchaseId(id);
    }


    public void updateWithAssociatedLists(Purchase purchase){
    if(purchase !=null && purchase.getId() != null){
            List<List<PurchaseItem>> resultPurchaseItems= purchaseItemService.getToBeSavedAndToBeDeleted(purchaseItemService.findByPurchaseId(purchase.getId()),purchase.getPurchaseItems());
            purchaseItemService.delete(resultPurchaseItems.get(1));
            ListUtil.emptyIfNull(resultPurchaseItems.get(0)).forEach(e -> e.setPurchase(purchase));
            purchaseItemService.update(resultPurchaseItems.get(0),true);
            List<List<PurchaseTag>> resultPurchaseTags= purchaseTagService.getToBeSavedAndToBeDeleted(purchaseTagService.findByPurchaseId(purchase.getId()),purchase.getPurchaseTags());
            purchaseTagService.delete(resultPurchaseTags.get(1));
            ListUtil.emptyIfNull(resultPurchaseTags.get(0)).forEach(e -> e.setPurchase(purchase));
            purchaseTagService.update(resultPurchaseTags.get(0),true);
    }
    }

    public Purchase findByReferenceEntity(Purchase t){
        return  dao.findByReference(t.getReference());
    }

    public List<Purchase> findByClientId(Long id){
        return dao.findByClientId(id);
    }
    public int deleteByClientId(Long id){
        return dao.deleteByClientId(id);
    }




    public void configure() {
        super.configure(Purchase.class,PurchaseHistory.class, PurchaseHistoryCriteria.class, PurchaseSpecification.class);
    }

    @Autowired
    private PurchaseItemAdminService purchaseItemService ;
    @Autowired
    private PurchaseTagAdminService purchaseTagService ;
    @Autowired
    private ClientAdminService clientService ;

    public PurchaseAdminServiceImpl(PurchaseDao dao, PurchaseHistoryDao historyDao) {
        super(dao, historyDao);
    }

}