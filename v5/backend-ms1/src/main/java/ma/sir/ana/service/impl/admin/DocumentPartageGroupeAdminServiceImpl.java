package ma.sir.ana.service.impl.admin;

import ma.sir.ana.bean.core.DocumentPartageGroupe;
import ma.sir.ana.bean.history.DocumentPartageGroupeHistory;
import ma.sir.ana.dao.criteria.core.DocumentPartageGroupeCriteria;
import ma.sir.ana.dao.criteria.history.DocumentPartageGroupeHistoryCriteria;
import ma.sir.ana.dao.facade.core.DocumentPartageGroupeDao;
import ma.sir.ana.dao.facade.history.DocumentPartageGroupeHistoryDao;
import ma.sir.ana.dao.specification.core.DocumentPartageGroupeSpecification;
import ma.sir.ana.service.facade.admin.DocumentPartageGroupeAdminService;
import ma.sir.ana.zynerator.service.AbstractServiceImpl;
import ma.sir.ana.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.ana.service.facade.admin.DocumentAdminService ;
import ma.sir.ana.service.facade.admin.GroupeAdminService ;
import ma.sir.ana.service.facade.admin.AcessShareAdminService ;



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
    private DocumentAdminService documentService ;
    @Autowired
    private GroupeAdminService groupeService ;
    @Autowired
    private AcessShareAdminService acessShareService ;

    public DocumentPartageGroupeAdminServiceImpl(DocumentPartageGroupeDao dao, DocumentPartageGroupeHistoryDao historyDao) {
        super(dao, historyDao);
    }

}