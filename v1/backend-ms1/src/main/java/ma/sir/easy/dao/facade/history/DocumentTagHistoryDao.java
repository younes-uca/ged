package ma.sir.easy.dao.facade.history;

import ma.sir.easy.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easy.bean.history.DocumentTagHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentTagHistoryDao extends AbstractHistoryRepository<DocumentTagHistory,Long> {

}
