package ma.sir.easy.service.facade.admin;

import java.util.List;
import ma.sir.easy.bean.core.GroupeUtilisateur;
import ma.sir.easy.dao.criteria.core.GroupeUtilisateurCriteria;
import ma.sir.easy.dao.criteria.history.GroupeUtilisateurHistoryCriteria;
import ma.sir.easy.zynerator.service.IService;


public interface GroupeUtilisateurAdminService extends  IService<GroupeUtilisateur,GroupeUtilisateurCriteria, GroupeUtilisateurHistoryCriteria>  {

    List<GroupeUtilisateur> findByGroupeId(Long id);
    int deleteByGroupeId(Long id);
    List<GroupeUtilisateur> findByUtilisateurId(Long id);
    int deleteByUtilisateurId(Long id);



}
