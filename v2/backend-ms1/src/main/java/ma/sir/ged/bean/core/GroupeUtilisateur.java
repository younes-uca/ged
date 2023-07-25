package ma.sir.ged.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ged.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "groupe_utilisateur")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="groupe_utilisateur_seq",sequenceName="groupe_utilisateur_seq",allocationSize=1, initialValue = 1)
public class GroupeUtilisateur   extends AuditBusinessObject     {

    private Long id;


    private Groupe groupe ;
    
    private Utilisateur utilisateur ;
    


    public GroupeUtilisateur(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="groupe_utilisateur_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Groupe getGroupe(){
        return this.groupe;
    }
    public void setGroupe(Groupe groupe){
        this.groupe = groupe;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Utilisateur getUtilisateur(){
        return this.utilisateur;
    }
    public void setUtilisateur(Utilisateur utilisateur){
        this.utilisateur = utilisateur;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupeUtilisateur groupeUtilisateur = (GroupeUtilisateur) o;
        return id != null && id.equals(groupeUtilisateur.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

