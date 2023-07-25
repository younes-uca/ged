package ma.sir.easy.dao.facade.history;

import ma.sir.easy.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easy.bean.history.AcessManagementHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface AcessManagementHistoryDao extends AbstractHistoryRepository<AcessManagementHistory,Long> {

}
