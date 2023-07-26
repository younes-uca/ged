package ma.sir.chocho.dao.facade.history;

import ma.sir.chocho.zynerator.repository.AbstractHistoryRepository;
import ma.sir.chocho.bean.history.ClientHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientHistoryDao extends AbstractHistoryRepository<ClientHistory,Long> {

}
