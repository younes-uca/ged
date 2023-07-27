package ma.sir.chocho.dao.facade.history;

import ma.sir.chocho.zynerator.repository.AbstractHistoryRepository;
import ma.sir.chocho.bean.history.DocumentManagementGroupeHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentManagementGroupeHistoryDao extends AbstractHistoryRepository<DocumentManagementGroupeHistory,Long> {

}
