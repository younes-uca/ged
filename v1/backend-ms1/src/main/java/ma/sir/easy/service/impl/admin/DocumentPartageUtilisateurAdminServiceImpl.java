package ma.sir.easy.service.impl.admin;

import ma.sir.easy.bean.core.DocumentPartageUtilisateur;
import ma.sir.easy.bean.history.DocumentPartageUtilisateurHistory;
import ma.sir.easy.dao.criteria.core.DocumentPartageUtilisateurCriteria;
import ma.sir.easy.dao.criteria.history.DocumentPartageUtilisateurHistoryCriteria;
import ma.sir.easy.dao.facade.core.DocumentPartageUtilisateurDao;
import ma.sir.easy.dao.facade.history.DocumentPartageUtilisateurHistoryDao;
import ma.sir.easy.dao.specification.core.DocumentPartageUtilisateurSpecification;
import ma.sir.easy.service.facade.admin.DocumentPartageUtilisateurAdminService;
import ma.sir.easy.zynerator.service.AbstractServiceImpl;
import ma.sir.easy.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.easy.service.facade.admin.AcessShareAdminService ;
import ma.sir.easy.service.facade.admin.DocumentAdminService ;
import ma.sir.easy.service.facade.admin.UtilisateurAdminService ;



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
    private AcessShareAdminService acessShareService ;
    @Autowired
    private DocumentAdminService documentService ;
    @Autowired
    private UtilisateurAdminService utilisateurService ;

    public DocumentPartageUtilisateurAdminServiceImpl(DocumentPartageUtilisateurDao dao, DocumentPartageUtilisateurHistoryDao historyDao) {
        super(dao, historyDao);
    }

}