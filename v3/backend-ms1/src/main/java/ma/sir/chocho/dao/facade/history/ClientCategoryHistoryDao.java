package ma.sir.chocho.dao.facade.history;

import ma.sir.chocho.zynerator.repository.AbstractHistoryRepository;
import ma.sir.chocho.bean.history.ClientCategoryHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientCategoryHistoryDao extends AbstractHistoryRepository<ClientCategoryHistory,Long> {

}
