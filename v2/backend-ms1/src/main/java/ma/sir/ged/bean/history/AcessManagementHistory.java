package ma.sir.ged.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ged.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "acess_management")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="acess_management_seq",sequenceName="acess_management_seq",allocationSize=1, initialValue = 1)
public class AcessManagementHistory extends HistBusinessObject  {


    public AcessManagementHistory() {
    super();
    }

    public AcessManagementHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="acess_management_seq")
    public Long getId() {
    return id;
    }
}

