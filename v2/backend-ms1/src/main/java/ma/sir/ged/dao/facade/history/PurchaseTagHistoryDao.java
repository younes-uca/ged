package ma.sir.ged.dao.facade.history;

import ma.sir.ged.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ged.bean.history.PurchaseTagHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseTagHistoryDao extends AbstractHistoryRepository<PurchaseTagHistory,Long> {

}
