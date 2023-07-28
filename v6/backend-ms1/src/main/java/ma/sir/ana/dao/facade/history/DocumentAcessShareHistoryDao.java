package ma.sir.ana.dao.facade.history;

import ma.sir.ana.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ana.bean.history.DocumentAcessShareHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentAcessShareHistoryDao extends AbstractHistoryRepository<DocumentAcessShareHistory,Long> {

}
