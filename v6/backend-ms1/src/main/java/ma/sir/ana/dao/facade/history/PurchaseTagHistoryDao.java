package ma.sir.ana.dao.facade.history;

import ma.sir.ana.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ana.bean.history.PurchaseTagHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseTagHistoryDao extends AbstractHistoryRepository<PurchaseTagHistory,Long> {

}
