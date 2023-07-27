package ma.sir.ana.dao.facade.history;

import ma.sir.ana.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ana.bean.history.DocumentTagHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentTagHistoryDao extends AbstractHistoryRepository<DocumentTagHistory,Long> {

}
