package ma.sir.easy.dao.facade.history;

import ma.sir.easy.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easy.bean.history.UtilisateurHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurHistoryDao extends AbstractHistoryRepository<UtilisateurHistory,Long> {

}
