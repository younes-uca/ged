package ma.sir.ana.dao.facade.history;

import ma.sir.ana.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ana.bean.history.DocumentTypeHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentTypeHistoryDao extends AbstractHistoryRepository<DocumentTypeHistory,Long> {

}
