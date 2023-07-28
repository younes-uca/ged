package ma.sir.ana.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ana.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "purchase_tag")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="purchase_tag_seq",sequenceName="purchase_tag_seq",allocationSize=1, initialValue = 1)
public class PurchaseTagHistory extends HistBusinessObject  {


    public PurchaseTagHistory() {
    super();
    }

    public PurchaseTagHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="purchase_tag_seq")
    public Long getId() {
    return id;
    }
}

