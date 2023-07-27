package ma.sir.ana.service.facade.admin;

import java.util.List;
import ma.sir.ana.bean.core.Product;
import ma.sir.ana.dao.criteria.core.ProductCriteria;
import ma.sir.ana.dao.criteria.history.ProductHistoryCriteria;
import ma.sir.ana.zynerator.service.IService;


public interface ProductAdminService extends  IService<Product,ProductCriteria, ProductHistoryCriteria>  {




}
