package  ma.sir.chocho.dao.specification.core;

import ma.sir.chocho.zynerator.specification.AbstractSpecification;
import ma.sir.chocho.dao.criteria.core.ProductCriteria;
import ma.sir.chocho.bean.core.Product;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ProductSpecification extends  AbstractSpecification<ProductCriteria, Product>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicateBigDecimal("purchaseCost", criteria.getPurchaseCost(), criteria.getPurchaseCostMin(), criteria.getPurchaseCostMax());
    }

    public ProductSpecification(ProductCriteria criteria) {
        super(criteria);
    }

    public ProductSpecification(ProductCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
