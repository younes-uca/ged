package ma.sir.chocho.service.impl.admin;

import ma.sir.chocho.bean.core.DocumentManagementUtilisateur;
import ma.sir.chocho.bean.history.DocumentManagementUtilisateurHistory;
import ma.sir.chocho.dao.criteria.core.DocumentManagementUtilisateurCriteria;
import ma.sir.chocho.dao.criteria.history.DocumentManagementUtilisateurHistoryCriteria;
import ma.sir.chocho.dao.facade.core.DocumentManagementUtilisateurDao;
import ma.sir.chocho.dao.facade.history.DocumentManagementUtilisateurHistoryDao;
import ma.sir.chocho.dao.specification.core.DocumentManagementUtilisateurSpecification;
import ma.sir.chocho.service.facade.admin.DocumentManagementUtilisateurAdminService;
import ma.sir.chocho.zynerator.service.AbstractServiceImpl;
import ma.sir.chocho.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.chocho.service.facade.admin.DocumentAdminService ;
import ma.sir.chocho.service.facade.admin.UtilisateurAdminService ;
import ma.sir.chocho.service.facade.admin.AcessManagementAdminService ;



import java.util.List;
@Service
public class DocumentManagementUtilisateurAdminServiceImpl extends AbstractServiceImpl<DocumentManagementUtilisateur,DocumentManagementUtilisateurHistory, DocumentManagementUtilisateurCriteria, DocumentManagementUtilisateurHistoryCriteria, DocumentManagementUtilisateurDao,
DocumentManagementUtilisateurHistoryDao> implements DocumentManagementUtilisateurAdminService {




    public List<DocumentManagementUtilisateur> findByDocumentId(Long id){
        return dao.findByDocumentId(id);
    }
    public int deleteByDocumentId(Long id){
        return dao.deleteByDocumentId(id);
    }
    public List<DocumentManagementUtilisateur> findByUtilisateurId(Long id){
        return dao.findByUtilisateurId(id);
    }
    public int deleteByUtilisateurId(Long id){
        return dao.deleteByUtilisateurId(id);
    }
    public List<DocumentManagementUtilisateur> findByAcessManagementId(Long id){
        return dao.findByAcessManagementId(id);
    }
    public int deleteByAcessManagementId(Long id){
        return dao.deleteByAcessManagementId(id);
    }




    public void configure() {
        super.configure(DocumentManagementUtilisateur.class,DocumentManagementUtilisateurHistory.class, DocumentManagementUtilisateurHistoryCriteria.class, DocumentManagementUtilisateurSpecification.class);
    }

    @Autowired
    private DocumentAdminService documentService ;
    @Autowired
    private UtilisateurAdminService utilisateurService ;
    @Autowired
    private AcessManagementAdminService acessManagementService ;

    public DocumentManagementUtilisateurAdminServiceImpl(DocumentManagementUtilisateurDao dao, DocumentManagementUtilisateurHistoryDao historyDao) {
        super(dao, historyDao);
    }

}