package ma.sir.chocho.dao.facade.history;

import ma.sir.chocho.zynerator.repository.AbstractHistoryRepository;
import ma.sir.chocho.bean.history.DocumentAcessShareHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentAcessShareHistoryDao extends AbstractHistoryRepository<DocumentAcessShareHistory,Long> {

}
