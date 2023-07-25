package ma.sir.easy.service.impl.admin;

import ma.sir.easy.bean.core.DocumentPartageGroupe;
import ma.sir.easy.bean.history.DocumentPartageGroupeHistory;
import ma.sir.easy.dao.criteria.core.DocumentPartageGroupeCriteria;
import ma.sir.easy.dao.criteria.history.DocumentPartageGroupeHistoryCriteria;
import ma.sir.easy.dao.facade.core.DocumentPartageGroupeDao;
import ma.sir.easy.dao.facade.history.DocumentPartageGroupeHistoryDao;
import ma.sir.easy.dao.specification.core.DocumentPartageGroupeSpecification;
import ma.sir.easy.service.facade.admin.DocumentPartageGroupeAdminService;
import ma.sir.easy.zynerator.service.AbstractServiceImpl;
import ma.sir.easy.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.easy.service.facade.admin.GroupeAdminService ;
import ma.sir.easy.service.facade.admin.AcessShareAdminService ;
import ma.sir.easy.service.facade.admin.DocumentAdminService ;



import java.util.List;
@Service
public class DocumentPartageGroupeAdminServiceImpl extends AbstractServiceImpl<DocumentPartageGroupe,DocumentPartageGroupeHistory, DocumentPartageGroupeCriteria, DocumentPartageGroupeHistoryCriteria, DocumentPartageGroupeDao,
DocumentPartageGroupeHistoryDao> implements DocumentPartageGroupeAdminService {




    public List<DocumentPartageGroupe> findByDocumentId(Long id){
        return dao.findByDocumentId(id);
    }
    public int deleteByDocumentId(Long id){
        return dao.deleteByDocumentId(id);
    }
    public List<DocumentPartageGroupe> findByGroupeId(Long id){
        return dao.findByGroupeId(id);
    }
    public int deleteByGroupeId(Long id){
        return dao.deleteByGroupeId(id);
    }
    public List<DocumentPartageGroupe> findByAcessShareId(Long id){
        return dao.findByAcessShareId(id);
    }
    public int deleteByAcessShareId(Long id){
        return dao.deleteByAcessShareId(id);
    }




    public void configure() {
        super.configure(DocumentPartageGroupe.class,DocumentPartageGroupeHistory.class, DocumentPartageGroupeHistoryCriteria.class, DocumentPartageGroupeSpecification.class);
    }

    @Autowired
    private GroupeAdminService groupeService ;
    @Autowired
    private AcessShareAdminService acessShareService ;
    @Autowired
    private DocumentAdminService documentService ;

    public DocumentPartageGroupeAdminServiceImpl(DocumentPartageGroupeDao dao, DocumentPartageGroupeHistoryDao historyDao) {
        super(dao, historyDao);
    }

}