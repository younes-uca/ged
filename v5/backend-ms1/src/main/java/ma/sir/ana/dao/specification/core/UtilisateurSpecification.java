package  ma.sir.ana.dao.specification.core;

import ma.sir.ana.zynerator.specification.AbstractSpecification;
import ma.sir.ana.dao.criteria.core.UtilisateurCriteria;
import ma.sir.ana.bean.core.Utilisateur;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurSpecification extends  AbstractSpecification<UtilisateurCriteria, Utilisateur>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("email", criteria.getEmail(),criteria.getEmailLike());
        addPredicate("name", criteria.getName(),criteria.getNameLike());
    }

    public UtilisateurSpecification(UtilisateurCriteria criteria) {
        super(criteria);
    }

    public UtilisateurSpecification(UtilisateurCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
