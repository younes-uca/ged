package ma.sir.easy.service.impl.admin;

import ma.sir.easy.bean.core.AcessShare;
import ma.sir.easy.bean.history.AcessShareHistory;
import ma.sir.easy.dao.criteria.core.AcessShareCriteria;
import ma.sir.easy.dao.criteria.history.AcessShareHistoryCriteria;
import ma.sir.easy.dao.facade.core.AcessShareDao;
import ma.sir.easy.dao.facade.history.AcessShareHistoryDao;
import ma.sir.easy.dao.specification.core.AcessShareSpecification;
import ma.sir.easy.service.facade.admin.AcessShareAdminService;
import ma.sir.easy.zynerator.service.AbstractServiceImpl;
import ma.sir.easy.zynerator.util.ListUtil;
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