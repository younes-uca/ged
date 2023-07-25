package ma.sir.ged.dao.facade.history;

import ma.sir.ged.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ged.bean.history.AcessManagementHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface AcessManagementHistoryDao extends AbstractHistoryRepository<AcessManagementHistory,Long> {

}
