package ma.sir.ana.dao.facade.history;

import ma.sir.ana.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ana.bean.history.DocumentHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentHistoryDao extends AbstractHistoryRepository<DocumentHistory,Long> {

}
