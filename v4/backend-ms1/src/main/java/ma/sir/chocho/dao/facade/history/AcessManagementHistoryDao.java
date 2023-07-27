package ma.sir.chocho.dao.facade.history;

import ma.sir.chocho.zynerator.repository.AbstractHistoryRepository;
import ma.sir.chocho.bean.history.AcessManagementHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface AcessManagementHistoryDao extends AbstractHistoryRepository<AcessManagementHistory,Long> {

}
