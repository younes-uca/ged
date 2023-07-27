package ma.sir.chocho.dao.facade.history;

import ma.sir.chocho.zynerator.repository.AbstractHistoryRepository;
import ma.sir.chocho.bean.history.GroupeUtilisateurHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupeUtilisateurHistoryDao extends AbstractHistoryRepository<GroupeUtilisateurHistory,Long> {

}
