package ma.sir.chocho.dao.facade.history;

import ma.sir.chocho.zynerator.repository.AbstractHistoryRepository;
import ma.sir.chocho.bean.history.DocumentHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentHistoryDao extends AbstractHistoryRepository<DocumentHistory,Long> {

}
