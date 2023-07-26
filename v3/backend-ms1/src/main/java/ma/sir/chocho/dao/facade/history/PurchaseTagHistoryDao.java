package ma.sir.chocho.dao.facade.history;

import ma.sir.chocho.zynerator.repository.AbstractHistoryRepository;
import ma.sir.chocho.bean.history.PurchaseTagHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseTagHistoryDao extends AbstractHistoryRepository<PurchaseTagHistory,Long> {

}
