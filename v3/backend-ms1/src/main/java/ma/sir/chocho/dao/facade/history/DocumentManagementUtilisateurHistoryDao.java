package ma.sir.chocho.dao.facade.history;

import ma.sir.chocho.zynerator.repository.AbstractHistoryRepository;
import ma.sir.chocho.bean.history.DocumentManagementUtilisateurHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentManagementUtilisateurHistoryDao extends AbstractHistoryRepository<DocumentManagementUtilisateurHistory,Long> {

}
