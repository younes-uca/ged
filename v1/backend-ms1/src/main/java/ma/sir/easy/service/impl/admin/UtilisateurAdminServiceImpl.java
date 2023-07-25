package ma.sir.easy.service.impl.admin;

import ma.sir.easy.bean.core.Utilisateur;
import ma.sir.easy.bean.history.UtilisateurHistory;
import ma.sir.easy.dao.criteria.core.UtilisateurCriteria;
import ma.sir.easy.dao.criteria.history.UtilisateurHistoryCriteria;
import ma.sir.easy.dao.facade.core.UtilisateurDao;
import ma.sir.easy.dao.facade.history.UtilisateurHistoryDao;
import ma.sir.easy.dao.specification.core.UtilisateurSpecification;
import ma.sir.easy.service.facade.admin.UtilisateurAdminService;
import ma.sir.easy.zynerator.service.AbstractServiceImpl;
import ma.sir.easy.zynerator.util.ListUtil;
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