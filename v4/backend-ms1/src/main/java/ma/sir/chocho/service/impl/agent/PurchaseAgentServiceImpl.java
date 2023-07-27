package ma.sir.chocho.service.impl.agent;

import ma.sir.chocho.bean.core.Purchase;
import ma.sir.chocho.bean.history.PurchaseHistory;
import ma.sir.chocho.dao.criteria.core.PurchaseCriteria;
import ma.sir.chocho.dao.criteria.history.PurchaseHistoryCriteria;
import ma.sir.chocho.dao.facade.core.PurchaseDao;
import ma.sir.chocho.dao.facade.history.PurchaseHistoryDao;
import ma.sir.chocho.dao.specification.core.PurchaseSpecification;
import ma.sir.chocho.service.facade.agent.PurchaseAgentService;
import ma.sir.chocho.zynerator.service.AbstractServiceImpl;
import ma.sir.chocho.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.sir.chocho.bean.core.PurchaseItem;
import ma.sir.chocho.bean.core.PurchaseTag;

import ma.sir.chocho.service.facade.agent.ClientAgentService ;



import java.util.List;
@Service
public class PurchaseAgentServiceImpl extends AbstractServiceImpl<Purchase,PurchaseHistory, PurchaseCriteria, PurchaseHistoryCriteria, PurchaseDao,
PurchaseHistoryDao> implements PurchaseAgentService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Purchase create(Purchase t) {
        super.create(t);

        return t;
    }

    public Purchase findWithAssociatedLists(Long id){
        Purchase result = dao.findById(id).orElse(null);

        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {

    }


    public void updateWithAssociatedLists(Purchase purchase){

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
    private ClientAgentService clientService ;

    public PurchaseAgentServiceImpl(PurchaseDao dao, PurchaseHistoryDao historyDao) {
        super(dao, historyDao);
    }

}
