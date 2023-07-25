package ma.sir.easy.service.impl.admin;

import ma.sir.easy.bean.core.EntiteAdministrative;
import ma.sir.easy.bean.history.EntiteAdministrativeHistory;
import ma.sir.easy.dao.criteria.core.EntiteAdministrativeCriteria;
import ma.sir.easy.dao.criteria.history.EntiteAdministrativeHistoryCriteria;
import ma.sir.easy.dao.facade.core.EntiteAdministrativeDao;
import ma.sir.easy.dao.facade.history.EntiteAdministrativeHistoryDao;
import ma.sir.easy.dao.specification.core.EntiteAdministrativeSpecification;
import ma.sir.easy.service.facade.admin.EntiteAdministrativeAdminService;
import ma.sir.easy.zynerator.service.AbstractServiceImpl;
import ma.sir.easy.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.easy.service.facade.admin.UtilisateurAdminService ;



import java.util.List;
@Service
public class EntiteAdministrativeAdminServiceImpl extends AbstractServiceImpl<EntiteAdministrative,EntiteAdministrativeHistory, EntiteAdministrativeCriteria, EntiteAdministrativeHistoryCriteria, EntiteAdministrativeDao,
EntiteAdministrativeHistoryDao> implements EntiteAdministrativeAdminService {



    public EntiteAdministrative findByReferenceEntity(EntiteAdministrative t){
        return  dao.findByCode(t.getCode());
    }

    public List<EntiteAdministrative> findByUtilisateurId(Long id){
        return dao.findByUtilisateurId(id);
    }
    public int deleteByUtilisateurId(Long id){
        return dao.deleteByUtilisateurId(id);
    }




    public void configure() {
        super.configure(EntiteAdministrative.class,EntiteAdministrativeHistory.class, EntiteAdministrativeHistoryCriteria.class, EntiteAdministrativeSpecification.class);
    }

    @Autowired
    private UtilisateurAdminService utilisateurService ;

    public EntiteAdministrativeAdminServiceImpl(EntiteAdministrativeDao dao, EntiteAdministrativeHistoryDao historyDao) {
        super(dao, historyDao);
    }

}