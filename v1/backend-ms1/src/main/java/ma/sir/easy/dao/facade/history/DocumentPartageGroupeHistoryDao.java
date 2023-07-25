package ma.sir.easy.dao.facade.history;

import ma.sir.easy.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easy.bean.history.DocumentPartageGroupeHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentPartageGroupeHistoryDao extends AbstractHistoryRepository<DocumentPartageGroupeHistory,Long> {

}
