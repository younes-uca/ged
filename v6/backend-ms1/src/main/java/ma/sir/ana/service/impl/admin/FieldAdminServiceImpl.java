package ma.sir.ana.service.impl.admin;

import ma.sir.ana.bean.core.Field;
import ma.sir.ana.bean.history.FieldHistory;
import ma.sir.ana.dao.criteria.core.FieldCriteria;
import ma.sir.ana.dao.criteria.history.FieldHistoryCriteria;
import ma.sir.ana.dao.facade.core.FieldDao;
import ma.sir.ana.dao.facade.history.FieldHistoryDao;
import ma.sir.ana.dao.specification.core.FieldSpecification;
import ma.sir.ana.service.facade.admin.FieldAdminService;
import ma.sir.ana.zynerator.service.AbstractServiceImpl;
import ma.sir.ana.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;







import java.util.List;
@Service
public class FieldAdminServiceImpl extends AbstractServiceImpl<Field,FieldHistory, FieldCriteria, FieldHistoryCriteria, FieldDao,
FieldHistoryDao> implements FieldAdminService {



    public Field findByReferenceEntity(Field t){
        return  dao.findByCode(t.getCode());
    }





    public void configure() {
        super.configure(Field.class,FieldHistory.class, FieldHistoryCriteria.class, FieldSpecification.class);
    }


    public FieldAdminServiceImpl(FieldDao dao, FieldHistoryDao historyDao) {
        super(dao, historyDao);
    }

}