package ma.sir.ana.dao.facade.history;

import ma.sir.ana.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ana.bean.history.DocumentCategorieFieldHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentCategorieFieldHistoryDao extends AbstractHistoryRepository<DocumentCategorieFieldHistory,Long> {

}
