package ma.sir.easy.dao.facade.history;

import ma.sir.easy.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easy.bean.history.GroupeHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupeHistoryDao extends AbstractHistoryRepository<GroupeHistory,Long> {

}
