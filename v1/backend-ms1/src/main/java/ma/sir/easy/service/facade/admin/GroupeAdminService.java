package ma.sir.easy.service.facade.admin;

import java.util.List;
import ma.sir.easy.bean.core.Groupe;
import ma.sir.easy.dao.criteria.core.GroupeCriteria;
import ma.sir.easy.dao.criteria.history.GroupeHistoryCriteria;
import ma.sir.easy.zynerator.service.IService;


public interface GroupeAdminService extends  IService<Groupe,GroupeCriteria, GroupeHistoryCriteria>  {

    List<Groupe> findByUtilisateurId(Long id);
    int deleteByUtilisateurId(Long id);



}
