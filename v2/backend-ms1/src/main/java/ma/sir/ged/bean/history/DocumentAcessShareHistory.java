package ma.sir.ged.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ged.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "document_acess_share")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="document_acess_share_seq",sequenceName="document_acess_share_seq",allocationSize=1, initialValue = 1)
public class DocumentAcessShareHistory extends HistBusinessObject  {


    public DocumentAcessShareHistory() {
    super();
    }

    public DocumentAcessShareHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="document_acess_share_seq")
    public Long getId() {
    return id;
    }
}

