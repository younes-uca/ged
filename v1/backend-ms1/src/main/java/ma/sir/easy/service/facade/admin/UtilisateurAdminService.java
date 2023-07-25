package ma.sir.easy.service.facade.admin;

import java.util.List;
import ma.sir.easy.bean.core.Utilisateur;
import ma.sir.easy.dao.criteria.core.UtilisateurCriteria;
import ma.sir.easy.dao.criteria.history.UtilisateurHistoryCriteria;
import ma.sir.easy.zynerator.service.IService;


public interface UtilisateurAdminService extends  IService<Utilisateur,UtilisateurCriteria, UtilisateurHistoryCriteria>  {




}
