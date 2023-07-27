package ma.sir.ana.dao.facade.history;

import ma.sir.ana.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ana.bean.history.TagHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface TagHistoryDao extends AbstractHistoryRepository<TagHistory,Long> {

}
