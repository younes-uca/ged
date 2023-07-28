package ma.sir.ana.dao.facade.history;

import ma.sir.ana.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ana.bean.history.DocumentFieldHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentFieldHistoryDao extends AbstractHistoryRepository<DocumentFieldHistory,Long> {

}
