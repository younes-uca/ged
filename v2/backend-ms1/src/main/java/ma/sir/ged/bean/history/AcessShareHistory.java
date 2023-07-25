package ma.sir.ged.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ged.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "acess_share")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="acess_share_seq",sequenceName="acess_share_seq",allocationSize=1, initialValue = 1)
public class AcessShareHistory extends HistBusinessObject  {


    public AcessShareHistory() {
    super();
    }

    public AcessShareHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="acess_share_seq")
    public Long getId() {
    return id;
    }
}

