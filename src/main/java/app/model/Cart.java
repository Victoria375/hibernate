package app.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "cart")
public class Cart implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn (name = "order_id")
    private Orders orders;

    @ManyToOne
    @JoinColumn (name = "product_id")
    private Product product;

    @Column (name = "quantity")
    private int quantity;

    @Column (name = "price")
    private int price;

    @Override
    public String toString() {
        return String.format("CartEntry {id = %s, order_id = %s, product_id = %s, quantity = %s, price = %s}",
                id, orders.getId(), product.getId(), quantity, price);
    }
}
