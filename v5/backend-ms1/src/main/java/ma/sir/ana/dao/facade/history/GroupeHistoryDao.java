package ma.sir.ana.dao.facade.history;

import ma.sir.ana.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ana.bean.history.GroupeHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupeHistoryDao extends AbstractHistoryRepository<GroupeHistory,Long> {

}
