package ma.sir.chocho.service.facade.admin;

import java.util.List;
import ma.sir.chocho.bean.core.EntiteAdministrative;
import ma.sir.chocho.dao.criteria.core.EntiteAdministrativeCriteria;
import ma.sir.chocho.dao.criteria.history.EntiteAdministrativeHistoryCriteria;
import ma.sir.chocho.zynerator.service.IService;


public interface EntiteAdministrativeAdminService extends  IService<EntiteAdministrative,EntiteAdministrativeCriteria, EntiteAdministrativeHistoryCriteria>  {

    List<EntiteAdministrative> findByUtilisateurId(Long id);
    int deleteByUtilisateurId(Long id);



}
