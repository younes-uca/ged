package ma.sir.easy.dao.facade.history;

import ma.sir.easy.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easy.bean.history.EntiteAdministrativeHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface EntiteAdministrativeHistoryDao extends AbstractHistoryRepository<EntiteAdministrativeHistory,Long> {

}
