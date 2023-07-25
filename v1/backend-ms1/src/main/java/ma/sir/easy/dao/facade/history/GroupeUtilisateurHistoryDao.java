package ma.sir.easy.dao.facade.history;

import ma.sir.easy.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easy.bean.history.GroupeUtilisateurHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupeUtilisateurHistoryDao extends AbstractHistoryRepository<GroupeUtilisateurHistory,Long> {

}
