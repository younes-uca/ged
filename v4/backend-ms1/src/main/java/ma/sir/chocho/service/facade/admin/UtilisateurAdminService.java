package ma.sir.chocho.service.facade.admin;

import java.util.List;
import ma.sir.chocho.bean.core.Utilisateur;
import ma.sir.chocho.dao.criteria.core.UtilisateurCriteria;
import ma.sir.chocho.dao.criteria.history.UtilisateurHistoryCriteria;
import ma.sir.chocho.zynerator.service.IService;


public interface UtilisateurAdminService extends  IService<Utilisateur,UtilisateurCriteria, UtilisateurHistoryCriteria>  {




}
