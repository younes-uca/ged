package ma.sir.easy.dao.facade.history;

import ma.sir.easy.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easy.bean.history.DocumentAcessShareHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentAcessShareHistoryDao extends AbstractHistoryRepository<DocumentAcessShareHistory,Long> {

}
