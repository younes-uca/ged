package ma.sir.chocho.dao.facade.history;

import ma.sir.chocho.zynerator.repository.AbstractHistoryRepository;
import ma.sir.chocho.bean.history.PurchaseHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseHistoryDao extends AbstractHistoryRepository<PurchaseHistory,Long> {

}
