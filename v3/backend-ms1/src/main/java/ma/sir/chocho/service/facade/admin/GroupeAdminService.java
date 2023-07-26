package ma.sir.chocho.service.facade.admin;

import java.util.List;
import ma.sir.chocho.bean.core.Groupe;
import ma.sir.chocho.dao.criteria.core.GroupeCriteria;
import ma.sir.chocho.dao.criteria.history.GroupeHistoryCriteria;
import ma.sir.chocho.zynerator.service.IService;


public interface GroupeAdminService extends  IService<Groupe,GroupeCriteria, GroupeHistoryCriteria>  {

    List<Groupe> findByUtilisateurId(Long id);
    int deleteByUtilisateurId(Long id);



}
