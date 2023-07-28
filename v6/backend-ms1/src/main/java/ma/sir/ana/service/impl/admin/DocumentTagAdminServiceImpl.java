package ma.sir.ana.service.impl.admin;

import ma.sir.ana.bean.core.DocumentTag;
import ma.sir.ana.bean.history.DocumentTagHistory;
import ma.sir.ana.dao.criteria.core.DocumentTagCriteria;
import ma.sir.ana.dao.criteria.history.DocumentTagHistoryCriteria;
import ma.sir.ana.dao.facade.core.DocumentTagDao;
import ma.sir.ana.dao.facade.history.DocumentTagHistoryDao;
import ma.sir.ana.dao.specification.core.DocumentTagSpecification;
import ma.sir.ana.service.facade.admin.DocumentTagAdminService;
import ma.sir.ana.zynerator.service.AbstractServiceImpl;
import ma.sir.ana.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.ana.service.facade.admin.DocumentAdminService ;
import ma.sir.ana.service.facade.admin.TagAdminService ;



import java.util.List;
@Service
public class DocumentTagAdminServiceImpl extends AbstractServiceImpl<DocumentTag,DocumentTagHistory, DocumentTagCriteria, DocumentTagHistoryCriteria, DocumentTagDao,
DocumentTagHistoryDao> implements DocumentTagAdminService {




    public List<DocumentTag> findByDocumentId(Long id){
        return dao.findByDocumentId(id);
    }
    public int deleteByDocumentId(Long id){
        return dao.deleteByDocumentId(id);
    }
    public List<DocumentTag> findByTagId(Long id){
        return dao.findByTagId(id);
    }
    public int deleteByTagId(Long id){
        return dao.deleteByTagId(id);
    }




    public void configure() {
        super.configure(DocumentTag.class,DocumentTagHistory.class, DocumentTagHistoryCriteria.class, DocumentTagSpecification.class);
    }

    @Autowired
    private DocumentAdminService documentService ;
    @Autowired
    private TagAdminService tagService ;

    public DocumentTagAdminServiceImpl(DocumentTagDao dao, DocumentTagHistoryDao historyDao) {
        super(dao, historyDao);
    }

}