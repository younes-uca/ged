package ma.sir.easy.dao.facade.history;

import ma.sir.easy.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easy.bean.history.DocumentManagementUtilisateurHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentManagementUtilisateurHistoryDao extends AbstractHistoryRepository<DocumentManagementUtilisateurHistory,Long> {

}
