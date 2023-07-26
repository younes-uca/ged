package ma.sir.chocho.service.facade.admin;

import java.util.List;
import ma.sir.chocho.bean.core.GroupeUtilisateur;
import ma.sir.chocho.dao.criteria.core.GroupeUtilisateurCriteria;
import ma.sir.chocho.dao.criteria.history.GroupeUtilisateurHistoryCriteria;
import ma.sir.chocho.zynerator.service.IService;


public interface GroupeUtilisateurAdminService extends  IService<GroupeUtilisateur,GroupeUtilisateurCriteria, GroupeUtilisateurHistoryCriteria>  {

    List<GroupeUtilisateur> findByGroupeId(Long id);
    int deleteByGroupeId(Long id);
    List<GroupeUtilisateur> findByUtilisateurId(Long id);
    int deleteByUtilisateurId(Long id);



}
