package ma.sir.ana.service.facade.admin;

import java.util.List;
import ma.sir.ana.bean.core.EntiteAdministrative;
import ma.sir.ana.dao.criteria.core.EntiteAdministrativeCriteria;
import ma.sir.ana.dao.criteria.history.EntiteAdministrativeHistoryCriteria;
import ma.sir.ana.zynerator.service.IService;


public interface EntiteAdministrativeAdminService extends  IService<EntiteAdministrative,EntiteAdministrativeCriteria, EntiteAdministrativeHistoryCriteria>  {

    List<EntiteAdministrative> findByUtilisateurId(Long id);
    int deleteByUtilisateurId(Long id);



}
