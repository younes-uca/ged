package ma.sir.easy.service.impl.admin;

import ma.sir.easy.bean.core.GroupeUtilisateur;
import ma.sir.easy.bean.history.GroupeUtilisateurHistory;
import ma.sir.easy.dao.criteria.core.GroupeUtilisateurCriteria;
import ma.sir.easy.dao.criteria.history.GroupeUtilisateurHistoryCriteria;
import ma.sir.easy.dao.facade.core.GroupeUtilisateurDao;
import ma.sir.easy.dao.facade.history.GroupeUtilisateurHistoryDao;
import ma.sir.easy.dao.specification.core.GroupeUtilisateurSpecification;
import ma.sir.easy.service.facade.admin.GroupeUtilisateurAdminService;
import ma.sir.easy.zynerator.service.AbstractServiceImpl;
import ma.sir.easy.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.easy.service.facade.admin.GroupeAdminService ;
import ma.sir.easy.service.facade.admin.UtilisateurAdminService ;



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
    private GroupeAdminService groupeService ;
    @Autowired
    private UtilisateurAdminService utilisateurService ;

    public GroupeUtilisateurAdminServiceImpl(GroupeUtilisateurDao dao, GroupeUtilisateurHistoryDao historyDao) {
        super(dao, historyDao);
    }

}