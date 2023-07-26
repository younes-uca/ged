package  ma.sir.chocho.dao.specification.core;

import ma.sir.chocho.zynerator.specification.AbstractSpecification;
import ma.sir.chocho.dao.criteria.core.AcessShareCriteria;
import ma.sir.chocho.bean.core.AcessShare;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class AcessShareSpecification extends  AbstractSpecification<AcessShareCriteria, AcessShare>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public AcessShareSpecification(AcessShareCriteria criteria) {
        super(criteria);
    }

    public AcessShareSpecification(AcessShareCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
