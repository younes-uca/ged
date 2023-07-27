package ma.sir.chocho.service.facade.admin;

import java.util.List;
import ma.sir.chocho.bean.core.Product;
import ma.sir.chocho.dao.criteria.core.ProductCriteria;
import ma.sir.chocho.dao.criteria.history.ProductHistoryCriteria;
import ma.sir.chocho.zynerator.service.IService;


public interface ProductAdminService extends  IService<Product,ProductCriteria, ProductHistoryCriteria>  {




}
