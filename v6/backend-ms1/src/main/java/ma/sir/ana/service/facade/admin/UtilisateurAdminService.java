package ma.sir.ana.service.facade.admin;

import java.util.List;
import ma.sir.ana.bean.core.Utilisateur;
import ma.sir.ana.dao.criteria.core.UtilisateurCriteria;
import ma.sir.ana.dao.criteria.history.UtilisateurHistoryCriteria;
import ma.sir.ana.zynerator.service.IService;


public interface UtilisateurAdminService extends  IService<Utilisateur,UtilisateurCriteria, UtilisateurHistoryCriteria>  {




}
