package ma.sir.easy.dao.facade.history;

import ma.sir.easy.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easy.bean.history.DocumentHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentHistoryDao extends AbstractHistoryRepository<DocumentHistory,Long> {

}
