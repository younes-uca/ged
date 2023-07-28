package ma.sir.ana.service.impl.admin;

import ma.sir.ana.bean.core.GroupeUtilisateur;
import ma.sir.ana.bean.history.GroupeUtilisateurHistory;
import ma.sir.ana.dao.criteria.core.GroupeUtilisateurCriteria;
import ma.sir.ana.dao.criteria.history.GroupeUtilisateurHistoryCriteria;
import ma.sir.ana.dao.facade.core.GroupeUtilisateurDao;
import ma.sir.ana.dao.facade.history.GroupeUtilisateurHistoryDao;
import ma.sir.ana.dao.specification.core.GroupeUtilisateurSpecification;
import ma.sir.ana.service.facade.admin.GroupeUtilisateurAdminService;
import ma.sir.ana.zynerator.service.AbstractServiceImpl;
import ma.sir.ana.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.ana.service.facade.admin.UtilisateurAdminService ;
import ma.sir.ana.service.facade.admin.GroupeAdminService ;



import java.util.List;
@Service
public class GroupeUtilisateurAdminServiceImpl extends AbstractServiceImpl<GroupeUtilisateur,GroupeUtilisateurHistory, GroupeUtilisateurCriteria, GroupeUtilisateurHistoryCriteria, GroupeUtilisateurDao,
GroupeUtilisateurHistoryDao> implements GroupeUtilisateurAdminService {




    public List<GroupeUtilisateur> findByGroupeId(Long id){
        return dao.findByGroupeId(id);
    }
    public int deleteByGroupeId(Long id){
        return dao.deleteByGroupeId(id);
    }
    public List<GroupeUtilisateur> findByUtilisateurId(Long id){
        return dao.findByUtilisateurId(id);
    }
    public int deleteByUtilisateurId(Long id){
        return dao.deleteByUtilisateurId(id);
    }




    public void configure() {
        super.configure(GroupeUtilisateur.class,GroupeUtilisateurHistory.class, GroupeUtilisateurHistoryCriteria.class, GroupeUtilisateurSpecification.class);
    }

    @Autowired
    private UtilisateurAdminService utilisateurService ;
    @Autowired
    private GroupeAdminService groupeService ;

    public GroupeUtilisateurAdminServiceImpl(GroupeUtilisateurDao dao, GroupeUtilisateurHistoryDao historyDao) {
        super(dao, historyDao);
    }

}