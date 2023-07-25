package ma.sir.easy.service.impl.admin;

import ma.sir.easy.bean.core.DocumentManagementGroupe;
import ma.sir.easy.bean.history.DocumentManagementGroupeHistory;
import ma.sir.easy.dao.criteria.core.DocumentManagementGroupeCriteria;
import ma.sir.easy.dao.criteria.history.DocumentManagementGroupeHistoryCriteria;
import ma.sir.easy.dao.facade.core.DocumentManagementGroupeDao;
import ma.sir.easy.dao.facade.history.DocumentManagementGroupeHistoryDao;
import ma.sir.easy.dao.specification.core.DocumentManagementGroupeSpecification;
import ma.sir.easy.service.facade.admin.DocumentManagementGroupeAdminService;
import ma.sir.easy.zynerator.service.AbstractServiceImpl;
import ma.sir.easy.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.easy.service.facade.admin.AcessManagementAdminService ;
import ma.sir.easy.service.facade.admin.GroupeAdminService ;
import ma.sir.easy.service.facade.admin.DocumentAdminService ;



import java.util.List;
@Service
public class DocumentManagementGroupeAdminServiceImpl extends AbstractServiceImpl<DocumentManagementGroupe,DocumentManagementGroupeHistory, DocumentManagementGroupeCriteria, DocumentManagementGroupeHistoryCriteria, DocumentManagementGroupeDao,
DocumentManagementGroupeHistoryDao> implements DocumentManagementGroupeAdminService {




    public List<DocumentManagementGroupe> findByDocumentId(Long id){
        return dao.findByDocumentId(id);
    }
    public int deleteByDocumentId(Long id){
        return dao.deleteByDocumentId(id);
    }
    public List<DocumentManagementGroupe> findByGroupeId(Long id){
        return dao.findByGroupeId(id);
    }
    public int deleteByGroupeId(Long id){
        return dao.deleteByGroupeId(id);
    }
    public List<DocumentManagementGroupe> findByAcessManagementId(Long id){
        return dao.findByAcessManagementId(id);
    }
    public int deleteByAcessManagementId(Long id){
        return dao.deleteByAcessManagementId(id);
    }




    public void configure() {
        super.configure(DocumentManagementGroupe.class,DocumentManagementGroupeHistory.class, DocumentManagementGroupeHistoryCriteria.class, DocumentManagementGroupeSpecification.class);
    }

    @Autowired
    private AcessManagementAdminService acessManagementService ;
    @Autowired
    private GroupeAdminService groupeService ;
    @Autowired
    private DocumentAdminService documentService ;

    public DocumentManagementGroupeAdminServiceImpl(DocumentManagementGroupeDao dao, DocumentManagementGroupeHistoryDao historyDao) {
        super(dao, historyDao);
    }

}