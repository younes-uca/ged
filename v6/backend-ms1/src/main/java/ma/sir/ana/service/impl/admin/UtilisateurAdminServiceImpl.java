package ma.sir.ana.service.impl.admin;

import ma.sir.ana.bean.core.Utilisateur;
import ma.sir.ana.bean.history.UtilisateurHistory;
import ma.sir.ana.dao.criteria.core.UtilisateurCriteria;
import ma.sir.ana.dao.criteria.history.UtilisateurHistoryCriteria;
import ma.sir.ana.dao.facade.core.UtilisateurDao;
import ma.sir.ana.dao.facade.history.UtilisateurHistoryDao;
import ma.sir.ana.dao.specification.core.UtilisateurSpecification;
import ma.sir.ana.service.facade.admin.UtilisateurAdminService;
import ma.sir.ana.zynerator.service.AbstractServiceImpl;
import ma.sir.ana.zynerator.util.ListUtil;
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