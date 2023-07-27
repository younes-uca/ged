package ma.sir.ana.service.impl.agent;

import ma.sir.ana.bean.core.Purchase;
import ma.sir.ana.bean.history.PurchaseHistory;
import ma.sir.ana.dao.criteria.core.PurchaseCriteria;
import ma.sir.ana.dao.criteria.history.PurchaseHistoryCriteria;
import ma.sir.ana.dao.facade.core.PurchaseDao;
import ma.sir.ana.dao.facade.history.PurchaseHistoryDao;
import ma.sir.ana.dao.specification.core.PurchaseSpecification;
import ma.sir.ana.service.facade.agent.ClientAgentService;
import ma.sir.ana.service.facade.agent.PurchaseAgentService;
import ma.sir.ana.zynerator.service.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PurchaseAgentServiceImpl extends AbstractServiceImpl<Purchase, PurchaseHistory, PurchaseCriteria, PurchaseHistoryCriteria, PurchaseDao,
        PurchaseHistoryDao> implements PurchaseAgentService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Purchase create(Purchase t) {
        super.create(t);

        return t;
    }

    public Purchase findWithAssociatedLists(Long id) {
        Purchase result = dao.findById(id).orElse(null);

        return result;
    }

    @Transactional
    public void deleteAssociatedLists(Long id) {

    }


    public void updateWithAssociatedLists(Purchase purchase) {
        if (purchase != null && purchase.getId() != null) {

        }
    }

    public Purchase findByReferenceEntity(Purchase t) {
        return dao.findByReference(t.getReference());
    }

    public List<Purchase> findByClientId(Long id) {
        return dao.findByClientId(id);
    }

    public int deleteByClientId(Long id) {
        return dao.deleteByClientId(id);
    }


    public void configure() {
        super.configure(Purchase.class, PurchaseHistory.class, PurchaseHistoryCriteria.class, PurchaseSpecification.class);
    }

    @Autowired
    private ClientAgentService clientService;

    public PurchaseAgentServiceImpl(PurchaseDao dao, PurchaseHistoryDao historyDao) {
        super(dao, historyDao);
    }

}
