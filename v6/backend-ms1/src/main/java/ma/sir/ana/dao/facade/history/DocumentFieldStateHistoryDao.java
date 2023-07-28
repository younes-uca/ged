package ma.sir.ana.dao.facade.history;

import ma.sir.ana.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ana.bean.history.DocumentFieldStateHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentFieldStateHistoryDao extends AbstractHistoryRepository<DocumentFieldStateHistory,Long> {

}
