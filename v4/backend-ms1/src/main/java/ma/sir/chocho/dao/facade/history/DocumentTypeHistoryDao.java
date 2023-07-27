package ma.sir.chocho.dao.facade.history;

import ma.sir.chocho.zynerator.repository.AbstractHistoryRepository;
import ma.sir.chocho.bean.history.DocumentTypeHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentTypeHistoryDao extends AbstractHistoryRepository<DocumentTypeHistory,Long> {

}
