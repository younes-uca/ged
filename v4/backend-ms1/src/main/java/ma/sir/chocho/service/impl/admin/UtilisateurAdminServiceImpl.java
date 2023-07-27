package ma.sir.chocho.service.impl.admin;

import ma.sir.chocho.bean.core.Utilisateur;
import ma.sir.chocho.bean.history.UtilisateurHistory;
import ma.sir.chocho.dao.criteria.core.UtilisateurCriteria;
import ma.sir.chocho.dao.criteria.history.UtilisateurHistoryCriteria;
import ma.sir.chocho.dao.facade.core.UtilisateurDao;
import ma.sir.chocho.dao.facade.history.UtilisateurHistoryDao;
import ma.sir.chocho.dao.specification.core.UtilisateurSpecification;
import ma.sir.chocho.service.facade.admin.UtilisateurAdminService;
import ma.sir.chocho.zynerator.service.AbstractServiceImpl;
import ma.sir.chocho.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;







import java.util.List;
@Service
public class UtilisateurAdminServiceImpl extends AbstractServiceImpl<Utilisateur,UtilisateurHistory, UtilisateurCriteria, UtilisateurHistoryCriteria, UtilisateurDao,
UtilisateurHistoryDao> implements UtilisateurAdminService {



    public Utilisateur findByReferenceEntity(Utilisateur t){
        return  dao.findByEmail(t.getEmail());
    }





    public void configure() {
        super.configure(Utilisateur.class,UtilisateurHistory.class, UtilisateurHistoryCriteria.class, UtilisateurSpecification.class);
    }


    public UtilisateurAdminServiceImpl(UtilisateurDao dao, UtilisateurHistoryDao historyDao) {
        super(dao, historyDao);
    }

}