package ma.sir.ana.dao.facade.history;

import ma.sir.ana.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ana.bean.history.FieldHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldHistoryDao extends AbstractHistoryRepository<FieldHistory,Long> {

}
