package ma.sir.ana.dao.facade.history;

import ma.sir.ana.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ana.bean.history.DocumentStateHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentStateHistoryDao extends AbstractHistoryRepository<DocumentStateHistory,Long> {

}
