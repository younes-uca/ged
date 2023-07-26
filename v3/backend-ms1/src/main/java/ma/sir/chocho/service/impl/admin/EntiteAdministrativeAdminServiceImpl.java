package ma.sir.chocho.service.impl.admin;

import ma.sir.chocho.bean.core.EntiteAdministrative;
import ma.sir.chocho.bean.history.EntiteAdministrativeHistory;
import ma.sir.chocho.dao.criteria.core.EntiteAdministrativeCriteria;
import ma.sir.chocho.dao.criteria.history.EntiteAdministrativeHistoryCriteria;
import ma.sir.chocho.dao.facade.core.EntiteAdministrativeDao;
import ma.sir.chocho.dao.facade.history.EntiteAdministrativeHistoryDao;
import ma.sir.chocho.dao.specification.core.EntiteAdministrativeSpecification;
import ma.sir.chocho.service.facade.admin.EntiteAdministrativeAdminService;
import ma.sir.chocho.zynerator.service.AbstractServiceImpl;
import ma.sir.chocho.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.chocho.service.facade.admin.UtilisateurAdminService ;



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