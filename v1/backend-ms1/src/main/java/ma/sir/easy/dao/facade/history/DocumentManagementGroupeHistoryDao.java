package ma.sir.easy.dao.facade.history;

import ma.sir.easy.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easy.bean.history.DocumentManagementGroupeHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentManagementGroupeHistoryDao extends AbstractHistoryRepository<DocumentManagementGroupeHistory,Long> {

}
