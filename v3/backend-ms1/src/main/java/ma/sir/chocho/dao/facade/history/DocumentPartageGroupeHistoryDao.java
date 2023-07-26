package ma.sir.chocho.dao.facade.history;

import ma.sir.chocho.zynerator.repository.AbstractHistoryRepository;
import ma.sir.chocho.bean.history.DocumentPartageGroupeHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentPartageGroupeHistoryDao extends AbstractHistoryRepository<DocumentPartageGroupeHistory,Long> {

}
