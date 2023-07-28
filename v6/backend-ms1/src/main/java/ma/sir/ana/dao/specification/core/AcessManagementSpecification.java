package  ma.sir.ana.dao.specification.core;

import ma.sir.ana.zynerator.specification.AbstractSpecification;
import ma.sir.ana.dao.criteria.core.AcessManagementCriteria;
import ma.sir.ana.bean.core.AcessManagement;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class AcessManagementSpecification extends  AbstractSpecification<AcessManagementCriteria, AcessManagement>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public AcessManagementSpecification(AcessManagementCriteria criteria) {
        super(criteria);
    }

    public AcessManagementSpecification(AcessManagementCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
