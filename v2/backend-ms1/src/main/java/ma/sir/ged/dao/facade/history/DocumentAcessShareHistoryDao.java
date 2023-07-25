package ma.sir.ged.dao.facade.history;

import ma.sir.ged.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ged.bean.history.DocumentAcessShareHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentAcessShareHistoryDao extends AbstractHistoryRepository<DocumentAcessShareHistory,Long> {

}
