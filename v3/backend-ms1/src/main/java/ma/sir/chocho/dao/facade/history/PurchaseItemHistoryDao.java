package ma.sir.chocho.dao.facade.history;

import ma.sir.chocho.zynerator.repository.AbstractHistoryRepository;
import ma.sir.chocho.bean.history.PurchaseItemHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseItemHistoryDao extends AbstractHistoryRepository<PurchaseItemHistory,Long> {

}
