package ma.sir.chocho.service.impl.admin;

import ma.sir.chocho.bean.core.AcessShare;
import ma.sir.chocho.bean.history.AcessShareHistory;
import ma.sir.chocho.dao.criteria.core.AcessShareCriteria;
import ma.sir.chocho.dao.criteria.history.AcessShareHistoryCriteria;
import ma.sir.chocho.dao.facade.core.AcessShareDao;
import ma.sir.chocho.dao.facade.history.AcessShareHistoryDao;
import ma.sir.chocho.dao.specification.core.AcessShareSpecification;
import ma.sir.chocho.service.facade.admin.AcessShareAdminService;
import ma.sir.chocho.zynerator.service.AbstractServiceImpl;
import ma.sir.chocho.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;







import java.util.List;
@Service
public class AcessShareAdminServiceImpl extends AbstractServiceImpl<AcessShare,AcessShareHistory, AcessShareCriteria, AcessShareHistoryCriteria, AcessShareDao,
AcessShareHistoryDao> implements AcessShareAdminService {



    public AcessShare findByReferenceEntity(AcessShare t){
        return  dao.findByCode(t.getCode());
    }





    public void configure() {
        super.configure(AcessShare.class,AcessShareHistory.class, AcessShareHistoryCriteria.class, AcessShareSpecification.class);
    }


    public AcessShareAdminServiceImpl(AcessShareDao dao, AcessShareHistoryDao historyDao) {
        super(dao, historyDao);
    }

}