package ma.sir.ana.dao.facade.history;

import ma.sir.ana.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ana.bean.history.AcessManagementHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface AcessManagementHistoryDao extends AbstractHistoryRepository<AcessManagementHistory,Long> {

}
