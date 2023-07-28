package ma.sir.ana.dao.facade.history;

import ma.sir.ana.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ana.bean.history.GroupeUtilisateurHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupeUtilisateurHistoryDao extends AbstractHistoryRepository<GroupeUtilisateurHistory,Long> {

}
