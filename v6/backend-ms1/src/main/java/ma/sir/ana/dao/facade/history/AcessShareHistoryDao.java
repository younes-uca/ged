package ma.sir.ana.dao.facade.history;

import ma.sir.ana.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ana.bean.history.AcessShareHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface AcessShareHistoryDao extends AbstractHistoryRepository<AcessShareHistory,Long> {

}
