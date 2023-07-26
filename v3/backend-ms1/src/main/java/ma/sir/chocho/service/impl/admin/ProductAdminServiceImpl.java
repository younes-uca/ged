package ma.sir.chocho.service.impl.admin;

import ma.sir.chocho.bean.core.Product;
import ma.sir.chocho.bean.history.ProductHistory;
import ma.sir.chocho.dao.criteria.core.ProductCriteria;
import ma.sir.chocho.dao.criteria.history.ProductHistoryCriteria;
import ma.sir.chocho.dao.facade.core.ProductDao;
import ma.sir.chocho.dao.facade.history.ProductHistoryDao;
import ma.sir.chocho.dao.specification.core.ProductSpecification;
import ma.sir.chocho.service.facade.admin.ProductAdminService;
import ma.sir.chocho.zynerator.service.AbstractServiceImpl;
import ma.sir.chocho.zynerator.util.ListUtil;
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