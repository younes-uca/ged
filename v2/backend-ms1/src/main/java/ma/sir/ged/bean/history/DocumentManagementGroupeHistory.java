package ma.sir.ged.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ged.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "document_management_groupe")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="document_management_groupe_seq",sequenceName="document_management_groupe_seq",allocationSize=1, initialValue = 1)
public class DocumentManagementGroupeHistory extends HistBusinessObject  {


    public DocumentManagementGroupeHistory() {
    super();
    }

    public DocumentManagementGroupeHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="document_management_groupe_seq")
    public Long getId() {
    return id;
    }
}

