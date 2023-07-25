package ma.sir.easy.dao.facade.history;

import ma.sir.easy.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easy.bean.history.TagHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface TagHistoryDao extends AbstractHistoryRepository<TagHistory,Long> {

}
