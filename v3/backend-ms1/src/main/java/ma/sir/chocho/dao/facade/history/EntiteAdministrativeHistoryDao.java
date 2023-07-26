package ma.sir.chocho.dao.facade.history;

import ma.sir.chocho.zynerator.repository.AbstractHistoryRepository;
import ma.sir.chocho.bean.history.EntiteAdministrativeHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface EntiteAdministrativeHistoryDao extends AbstractHistoryRepository<EntiteAdministrativeHistory,Long> {

}
