package ma.sir.ana.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ana.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "purchase_item")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="purchase_item_seq",sequenceName="purchase_item_seq",allocationSize=1, initialValue = 1)
public class PurchaseItem   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal price = BigDecimal.ZERO;
    private BigDecimal quantity = BigDecimal.ZERO;

    private Product product ;
    
    private Purchase purchase ;
    


    public PurchaseItem(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="purchase_item_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Product getProduct(){
        return this.product;
    }
    public void setProduct(Product product){
        this.product = product;
    }
    public BigDecimal getPrice(){
        return this.price;
    }
    public void setPrice(BigDecimal price){
        this.price = price;
    }
    public BigDecimal getQuantity(){
        return this.quantity;
    }
    public void setQuantity(BigDecimal quantity){
        this.quantity = quantity;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Purchase getPurchase(){
        return this.purchase;
    }
    public void setPurchase(Purchase purchase){
        this.purchase = purchase;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseItem purchaseItem = (PurchaseItem) o;
        return id != null && id.equals(purchaseItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

