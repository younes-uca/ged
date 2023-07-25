package ma.sir.ged.dao.facade.history;

import ma.sir.ged.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ged.bean.history.DocumentManagementUtilisateurHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentManagementUtilisateurHistoryDao extends AbstractHistoryRepository<DocumentManagementUtilisateurHistory,Long> {

}
