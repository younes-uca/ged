package ma.sir.easy.service.impl.admin;

import ma.sir.easy.bean.core.DocumentManagementUtilisateur;
import ma.sir.easy.bean.history.DocumentManagementUtilisateurHistory;
import ma.sir.easy.dao.criteria.core.DocumentManagementUtilisateurCriteria;
import ma.sir.easy.dao.criteria.history.DocumentManagementUtilisateurHistoryCriteria;
import ma.sir.easy.dao.facade.core.DocumentManagementUtilisateurDao;
import ma.sir.easy.dao.facade.history.DocumentManagementUtilisateurHistoryDao;
import ma.sir.easy.dao.specification.core.DocumentManagementUtilisateurSpecification;
import ma.sir.easy.service.facade.admin.DocumentManagementUtilisateurAdminService;
import ma.sir.easy.zynerator.service.AbstractServiceImpl;
import ma.sir.easy.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.easy.service.facade.admin.AcessManagementAdminService ;
import ma.sir.easy.service.facade.admin.DocumentAdminService ;
import ma.sir.easy.service.facade.admin.UtilisateurAdminService ;



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
    private AcessManagementAdminService acessManagementService ;
    @Autowired
    private DocumentAdminService documentService ;
    @Autowired
    private UtilisateurAdminService utilisateurService ;

    public DocumentManagementUtilisateurAdminServiceImpl(DocumentManagementUtilisateurDao dao, DocumentManagementUtilisateurHistoryDao historyDao) {
        super(dao, historyDao);
    }

}