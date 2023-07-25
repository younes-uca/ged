package ma.sir.easy.service.impl.admin;

import ma.sir.easy.bean.core.DocumentAcessShare;
import ma.sir.easy.bean.history.DocumentAcessShareHistory;
import ma.sir.easy.dao.criteria.core.DocumentAcessShareCriteria;
import ma.sir.easy.dao.criteria.history.DocumentAcessShareHistoryCriteria;
import ma.sir.easy.dao.facade.core.DocumentAcessShareDao;
import ma.sir.easy.dao.facade.history.DocumentAcessShareHistoryDao;
import ma.sir.easy.dao.specification.core.DocumentAcessShareSpecification;
import ma.sir.easy.service.facade.admin.DocumentAcessShareAdminService;
import ma.sir.easy.zynerator.service.AbstractServiceImpl;
import ma.sir.easy.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.easy.service.facade.admin.AcessShareAdminService ;
import ma.sir.easy.service.facade.admin.DocumentAdminService ;



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
    private AcessShareAdminService acessShareService ;
    @Autowired
    private DocumentAdminService documentService ;

    public DocumentAcessShareAdminServiceImpl(DocumentAcessShareDao dao, DocumentAcessShareHistoryDao historyDao) {
        super(dao, historyDao);
    }

}