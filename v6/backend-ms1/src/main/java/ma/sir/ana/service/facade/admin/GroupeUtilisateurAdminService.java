package ma.sir.ana.service.facade.admin;

import java.util.List;
import ma.sir.ana.bean.core.GroupeUtilisateur;
import ma.sir.ana.dao.criteria.core.GroupeUtilisateurCriteria;
import ma.sir.ana.dao.criteria.history.GroupeUtilisateurHistoryCriteria;
import ma.sir.ana.zynerator.service.IService;


public interface GroupeUtilisateurAdminService extends  IService<GroupeUtilisateur,GroupeUtilisateurCriteria, GroupeUtilisateurHistoryCriteria>  {

    List<GroupeUtilisateur> findByGroupeId(Long id);
    int deleteByGroupeId(Long id);
    List<GroupeUtilisateur> findByUtilisateurId(Long id);
    int deleteByUtilisateurId(Long id);



}
