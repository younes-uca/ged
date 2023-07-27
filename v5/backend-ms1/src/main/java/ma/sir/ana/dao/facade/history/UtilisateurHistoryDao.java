package ma.sir.ana.dao.facade.history;

import ma.sir.ana.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ana.bean.history.UtilisateurHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurHistoryDao extends AbstractHistoryRepository<UtilisateurHistory,Long> {

}
