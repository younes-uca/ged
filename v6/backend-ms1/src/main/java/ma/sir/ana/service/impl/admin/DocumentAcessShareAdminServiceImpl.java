package ma.sir.ana.service.impl.admin;

import ma.sir.ana.bean.core.DocumentAcessShare;
import ma.sir.ana.bean.history.DocumentAcessShareHistory;
import ma.sir.ana.dao.criteria.core.DocumentAcessShareCriteria;
import ma.sir.ana.dao.criteria.history.DocumentAcessShareHistoryCriteria;
import ma.sir.ana.dao.facade.core.DocumentAcessShareDao;
import ma.sir.ana.dao.facade.history.DocumentAcessShareHistoryDao;
import ma.sir.ana.dao.specification.core.DocumentAcessShareSpecification;
import ma.sir.ana.service.facade.admin.DocumentAcessShareAdminService;
import ma.sir.ana.zynerator.service.AbstractServiceImpl;
import ma.sir.ana.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.ana.service.facade.admin.DocumentAdminService ;
import ma.sir.ana.service.facade.admin.AcessShareAdminService ;



import java.util.List;
@Service
public class DocumentAcessShareAdminServiceImpl extends AbstractServiceImpl<DocumentAcessShare,DocumentAcessShareHistory, DocumentAcessShareCriteria, DocumentAcessShareHistoryCriteria, DocumentAcessShareDao,
DocumentAcessShareHistoryDao> implements DocumentAcessShareAdminService {




    public List<DocumentAcessShare> findByDocumentId(Long id){
        return dao.findByDocumentId(id);
    }
    public int deleteByDocumentId(Long id){
        return dao.deleteByDocumentId(id);
    }
    public List<DocumentAcessShare> findByAcessShareId(Long id){
        return dao.findByAcessShareId(id);
    }
    public int deleteByAcessShareId(Long id){
        return dao.deleteByAcessShareId(id);
    }




    public void configure() {
        super.configure(DocumentAcessShare.class,DocumentAcessShareHistory.class, DocumentAcessShareHistoryCriteria.class, DocumentAcessShareSpecification.class);
    }

    @Autowired
    private DocumentAdminService documentService ;
    @Autowired
    private AcessShareAdminService acessShareService ;

    public DocumentAcessShareAdminServiceImpl(DocumentAcessShareDao dao, DocumentAcessShareHistoryDao historyDao) {
        super(dao, historyDao);
    }

}