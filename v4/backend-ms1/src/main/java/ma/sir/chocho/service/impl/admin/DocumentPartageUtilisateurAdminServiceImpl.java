package ma.sir.chocho.service.impl.admin;

import ma.sir.chocho.bean.core.DocumentPartageUtilisateur;
import ma.sir.chocho.bean.history.DocumentPartageUtilisateurHistory;
import ma.sir.chocho.dao.criteria.core.DocumentPartageUtilisateurCriteria;
import ma.sir.chocho.dao.criteria.history.DocumentPartageUtilisateurHistoryCriteria;
import ma.sir.chocho.dao.facade.core.DocumentPartageUtilisateurDao;
import ma.sir.chocho.dao.facade.history.DocumentPartageUtilisateurHistoryDao;
import ma.sir.chocho.dao.specification.core.DocumentPartageUtilisateurSpecification;
import ma.sir.chocho.service.facade.admin.DocumentPartageUtilisateurAdminService;
import ma.sir.chocho.zynerator.service.AbstractServiceImpl;
import ma.sir.chocho.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.chocho.service.facade.admin.DocumentAdminService ;
import ma.sir.chocho.service.facade.admin.UtilisateurAdminService ;
import ma.sir.chocho.service.facade.admin.AcessShareAdminService ;



import java.util.List;
@Service
public class DocumentPartageUtilisateurAdminServiceImpl extends AbstractServiceImpl<DocumentPartageUtilisateur,DocumentPartageUtilisateurHistory, DocumentPartageUtilisateurCriteria, DocumentPartageUtilisateurHistoryCriteria, DocumentPartageUtilisateurDao,
DocumentPartageUtilisateurHistoryDao> implements DocumentPartageUtilisateurAdminService {




    public List<DocumentPartageUtilisateur> findByDocumentId(Long id){
        return dao.findByDocumentId(id);
    }
    public int deleteByDocumentId(Long id){
        return dao.deleteByDocumentId(id);
    }
    public List<DocumentPartageUtilisateur> findByUtilisateurId(Long id){
        return dao.findByUtilisateurId(id);
    }
    public int deleteByUtilisateurId(Long id){
        return dao.deleteByUtilisateurId(id);
    }
    public List<DocumentPartageUtilisateur> findByAcessShareId(Long id){
        return dao.findByAcessShareId(id);
    }
    public int deleteByAcessShareId(Long id){
        return dao.deleteByAcessShareId(id);
    }




    public void configure() {
        super.configure(DocumentPartageUtilisateur.class,DocumentPartageUtilisateurHistory.class, DocumentPartageUtilisateurHistoryCriteria.class, DocumentPartageUtilisateurSpecification.class);
    }

    @Autowired
    private DocumentAdminService documentService ;
    @Autowired
    private UtilisateurAdminService utilisateurService ;
    @Autowired
    private AcessShareAdminService acessShareService ;

    public DocumentPartageUtilisateurAdminServiceImpl(DocumentPartageUtilisateurDao dao, DocumentPartageUtilisateurHistoryDao historyDao) {
        super(dao, historyDao);
    }

}