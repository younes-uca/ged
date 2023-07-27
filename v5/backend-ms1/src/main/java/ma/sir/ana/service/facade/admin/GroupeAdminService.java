package ma.sir.ana.service.facade.admin;

import java.util.List;
import ma.sir.ana.bean.core.Groupe;
import ma.sir.ana.dao.criteria.core.GroupeCriteria;
import ma.sir.ana.dao.criteria.history.GroupeHistoryCriteria;
import ma.sir.ana.zynerator.service.IService;


public interface GroupeAdminService extends  IService<Groupe,GroupeCriteria, GroupeHistoryCriteria>  {

    List<Groupe> findByUtilisateurId(Long id);
    int deleteByUtilisateurId(Long id);



}
