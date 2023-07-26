package ma.sir.chocho.dao.facade.history;

import ma.sir.chocho.zynerator.repository.AbstractHistoryRepository;
import ma.sir.chocho.bean.history.GroupeHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupeHistoryDao extends AbstractHistoryRepository<GroupeHistory,Long> {

}
