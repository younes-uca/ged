package ma.sir.chocho.service.impl.admin;

import ma.sir.chocho.bean.core.DocumentTag;
import ma.sir.chocho.bean.history.DocumentTagHistory;
import ma.sir.chocho.dao.criteria.core.DocumentTagCriteria;
import ma.sir.chocho.dao.criteria.history.DocumentTagHistoryCriteria;
import ma.sir.chocho.dao.facade.core.DocumentTagDao;
import ma.sir.chocho.dao.facade.history.DocumentTagHistoryDao;
import ma.sir.chocho.dao.specification.core.DocumentTagSpecification;
import ma.sir.chocho.service.facade.admin.DocumentTagAdminService;
import ma.sir.chocho.zynerator.service.AbstractServiceImpl;
import ma.sir.chocho.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.chocho.service.facade.admin.DocumentAdminService ;
import ma.sir.chocho.service.facade.admin.TagAdminService ;



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