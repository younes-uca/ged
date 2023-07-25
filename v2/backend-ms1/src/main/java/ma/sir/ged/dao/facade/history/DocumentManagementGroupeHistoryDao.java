package ma.sir.ged.dao.facade.history;

import ma.sir.ged.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ged.bean.history.DocumentManagementGroupeHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentManagementGroupeHistoryDao extends AbstractHistoryRepository<DocumentManagementGroupeHistory,Long> {

}
