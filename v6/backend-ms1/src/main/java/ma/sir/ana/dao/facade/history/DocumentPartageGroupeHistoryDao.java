package ma.sir.ana.dao.facade.history;

import ma.sir.ana.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ana.bean.history.DocumentPartageGroupeHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentPartageGroupeHistoryDao extends AbstractHistoryRepository<DocumentPartageGroupeHistory,Long> {

}
