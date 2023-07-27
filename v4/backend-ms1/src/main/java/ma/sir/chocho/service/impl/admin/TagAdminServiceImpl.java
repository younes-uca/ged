package ma.sir.chocho.service.impl.admin;

import ma.sir.chocho.bean.core.Tag;
import ma.sir.chocho.bean.history.TagHistory;
import ma.sir.chocho.dao.criteria.core.TagCriteria;
import ma.sir.chocho.dao.criteria.history.TagHistoryCriteria;
import ma.sir.chocho.dao.facade.core.TagDao;
import ma.sir.chocho.dao.facade.history.TagHistoryDao;
import ma.sir.chocho.dao.specification.core.TagSpecification;
import ma.sir.chocho.service.facade.admin.TagAdminService;
import ma.sir.chocho.zynerator.service.AbstractServiceImpl;
import ma.sir.chocho.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;







import java.util.List;
@Service
public class TagAdminServiceImpl extends AbstractServiceImpl<Tag,TagHistory, TagCriteria, TagHistoryCriteria, TagDao,
TagHistoryDao> implements TagAdminService {



    public Tag findByReferenceEntity(Tag t){
        return  dao.findByCode(t.getCode());
    }





    public void configure() {
        super.configure(Tag.class,TagHistory.class, TagHistoryCriteria.class, TagSpecification.class);
    }


    public TagAdminServiceImpl(TagDao dao, TagHistoryDao historyDao) {
        super(dao, historyDao);
    }

}