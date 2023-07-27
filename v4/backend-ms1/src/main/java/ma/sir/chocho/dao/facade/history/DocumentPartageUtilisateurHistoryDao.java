package ma.sir.chocho.dao.facade.history;

import ma.sir.chocho.zynerator.repository.AbstractHistoryRepository;
import ma.sir.chocho.bean.history.DocumentPartageUtilisateurHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentPartageUtilisateurHistoryDao extends AbstractHistoryRepository<DocumentPartageUtilisateurHistory,Long> {

}
