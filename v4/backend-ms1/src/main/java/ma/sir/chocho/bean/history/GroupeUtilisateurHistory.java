package ma.sir.chocho.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.chocho.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "groupe_utilisateur")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="groupe_utilisateur_seq",sequenceName="groupe_utilisateur_seq",allocationSize=1, initialValue = 1)
public class GroupeUtilisateurHistory extends HistBusinessObject  {


    public GroupeUtilisateurHistory() {
    super();
    }

    public GroupeUtilisateurHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="groupe_utilisateur_seq")
    public Long getId() {
    return id;
    }
}

