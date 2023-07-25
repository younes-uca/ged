package ma.sir.ged.dao.facade.history;

import ma.sir.ged.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ged.bean.history.AcessShareHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface AcessShareHistoryDao extends AbstractHistoryRepository<AcessShareHistory,Long> {

}
