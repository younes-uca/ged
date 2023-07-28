package ma.sir.ana.dao.facade.history;

import ma.sir.ana.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ana.bean.history.DocumentManagementGroupeHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentManagementGroupeHistoryDao extends AbstractHistoryRepository<DocumentManagementGroupeHistory,Long> {

}
