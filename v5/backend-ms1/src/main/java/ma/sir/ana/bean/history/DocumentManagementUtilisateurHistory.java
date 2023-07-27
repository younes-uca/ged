package ma.sir.ana.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ana.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "document_management_utilisateur")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="document_management_utilisateur_seq",sequenceName="document_management_utilisateur_seq",allocationSize=1, initialValue = 1)
public class DocumentManagementUtilisateurHistory extends HistBusinessObject  {


    public DocumentManagementUtilisateurHistory() {
    super();
    }

    public DocumentManagementUtilisateurHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="document_management_utilisateur_seq")
    public Long getId() {
    return id;
    }
}
