package ma.sir.ana.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ana.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "document_type")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="document_type_seq",sequenceName="document_type_seq",allocationSize=1, initialValue = 1)
public class DocumentTypeHistory extends HistBusinessObject  {


    public DocumentTypeHistory() {
    super();
    }

    public DocumentTypeHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="document_type_seq")
    public Long getId() {
    return id;
    }
}

