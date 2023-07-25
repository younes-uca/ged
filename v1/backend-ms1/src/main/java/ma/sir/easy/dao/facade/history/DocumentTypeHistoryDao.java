package ma.sir.easy.dao.facade.history;

import ma.sir.easy.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easy.bean.history.DocumentTypeHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentTypeHistoryDao extends AbstractHistoryRepository<DocumentTypeHistory,Long> {

}
