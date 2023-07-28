package ma.sir.ana.service.impl.admin;

import ma.sir.ana.bean.core.Product;
import ma.sir.ana.bean.history.ProductHistory;
import ma.sir.ana.dao.criteria.core.ProductCriteria;
import ma.sir.ana.dao.criteria.history.ProductHistoryCriteria;
import ma.sir.ana.dao.facade.core.ProductDao;
import ma.sir.ana.dao.facade.history.ProductHistoryDao;
import ma.sir.ana.dao.specification.core.ProductSpecification;
import ma.sir.ana.service.facade.admin.ProductAdminService;
import ma.sir.ana.zynerator.service.AbstractServiceImpl;
import ma.sir.ana.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;







import java.util.List;
@Service
public class ProductAdminServiceImpl extends AbstractServiceImpl<Product,ProductHistory, ProductCriteria, ProductHistoryCriteria, ProductDao,
ProductHistoryDao> implements ProductAdminService {



    public Product findByReferenceEntity(Product t){
        return  dao.findByCode(t.getCode());
    }





    public void configure() {
        super.configure(Product.class,ProductHistory.class, ProductHistoryCriteria.class, ProductSpecification.class);
    }


    public ProductAdminServiceImpl(ProductDao dao, ProductHistoryDao historyDao) {
        super(dao, historyDao);
    }

}