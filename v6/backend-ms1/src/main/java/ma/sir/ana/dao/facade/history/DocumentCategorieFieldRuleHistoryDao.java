package ma.sir.ana.dao.facade.history;

import ma.sir.ana.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ana.bean.history.DocumentCategorieFieldRuleHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentCategorieFieldRuleHistoryDao extends AbstractHistoryRepository<DocumentCategorieFieldRuleHistory,Long> {

}
