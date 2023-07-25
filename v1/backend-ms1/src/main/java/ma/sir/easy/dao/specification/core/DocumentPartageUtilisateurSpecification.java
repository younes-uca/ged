package  ma.sir.easy.dao.specification.core;

import ma.sir.easy.zynerator.specification.AbstractSpecification;
import ma.sir.easy.dao.criteria.core.DocumentPartageUtilisateurCriteria;
import ma.sir.easy.bean.core.DocumentPartageUtilisateur;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class DocumentPartageUtilisateurSpecification extends  AbstractSpecification<DocumentPartageUtilisateurCriteria, DocumentPartageUtilisateur>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("dateShare", criteria.getDateShare(), criteria.getDateShareFrom(), criteria.getDateShareTo());
        addPredicateFk("document","id", criteria.getDocument()==null?null:criteria.getDocument().getId());
        addPredicateFk("document","id", criteria.getDocuments());
        addPredicateFk("document","reference", criteria.getDocument()==null?null:criteria.getDocument().getReference());
        addPredicateFk("utilisateur","id", criteria.getUtilisateur()==null?null:criteria.getUtilisateur().getId());
        addPredicateFk("utilisateur","id", criteria.getUtilisateurs());
        addPredicateFk("utilisateur","email", criteria.getUtilisateur()==null?null:criteria.getUtilisateur().getEmail());
        addPredicateFk("acessShare","id", criteria.getAcessShare()==null?null:criteria.getAcessShare().getId());
        addPredicateFk("acessShare","id", criteria.getAcessShares());
        addPredicateFk("acessShare","code", criteria.getAcessShare()==null?null:criteria.getAcessShare().getCode());
    }

    public DocumentPartageUtilisateurSpecification(DocumentPartageUtilisateurCriteria criteria) {
        super(criteria);
    }

    public DocumentPartageUtilisateurSpecification(DocumentPartageUtilisateurCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
