package ma.sir.ana.dao.facade.history;

import ma.sir.ana.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ana.bean.history.DocumentCategorieHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentCategorieHistoryDao extends AbstractHistoryRepository<DocumentCategorieHistory,Long> {

}
