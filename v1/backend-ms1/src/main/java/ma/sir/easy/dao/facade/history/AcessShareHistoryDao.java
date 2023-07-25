package ma.sir.easy.dao.facade.history;

import ma.sir.easy.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easy.bean.history.AcessShareHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface AcessShareHistoryDao extends AbstractHistoryRepository<AcessShareHistory,Long> {

}
