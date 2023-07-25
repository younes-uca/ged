package ma.sir.easy.service.facade.admin;

import java.util.List;
import ma.sir.easy.bean.core.EntiteAdministrative;
import ma.sir.easy.dao.criteria.core.EntiteAdministrativeCriteria;
import ma.sir.easy.dao.criteria.history.EntiteAdministrativeHistoryCriteria;
import ma.sir.easy.zynerator.service.IService;


public interface EntiteAdministrativeAdminService extends  IService<EntiteAdministrative,EntiteAdministrativeCriteria, EntiteAdministrativeHistoryCriteria>  {

    List<EntiteAdministrative> findByUtilisateurId(Long id);
    int deleteByUtilisateurId(Long id);



}
