package ma.sir.ged.dao.facade.history;

import ma.sir.ged.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ged.bean.history.DocumentCategorieFieldRuleHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentCategorieFieldRuleHistoryDao extends AbstractHistoryRepository<DocumentCategorieFieldRuleHistory,Long> {

}
