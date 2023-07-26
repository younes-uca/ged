package ma.sir.chocho.service.impl.admin;

import ma.sir.chocho.bean.core.DocumentManagementGroupe;
import ma.sir.chocho.bean.history.DocumentManagementGroupeHistory;
import ma.sir.chocho.dao.criteria.core.DocumentManagementGroupeCriteria;
import ma.sir.chocho.dao.criteria.history.DocumentManagementGroupeHistoryCriteria;
import ma.sir.chocho.dao.facade.core.DocumentManagementGroupeDao;
import ma.sir.chocho.dao.facade.history.DocumentManagementGroupeHistoryDao;
import ma.sir.chocho.dao.specification.core.DocumentManagementGroupeSpecification;
import ma.sir.chocho.service.facade.admin.DocumentManagementGroupeAdminService;
import ma.sir.chocho.zynerator.service.AbstractServiceImpl;
import ma.sir.chocho.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.chocho.service.facade.admin.DocumentAdminService ;
import ma.sir.chocho.service.facade.admin.GroupeAdminService ;
import ma.sir.chocho.service.facade.admin.AcessManagementAdminService ;



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
    private DocumentAdminService documentService ;
    @Autowired
    private GroupeAdminService groupeService ;
    @Autowired
    private AcessManagementAdminService acessManagementService ;

    public DocumentManagementGroupeAdminServiceImpl(DocumentManagementGroupeDao dao, DocumentManagementGroupeHistoryDao historyDao) {
        super(dao, historyDao);
    }

}