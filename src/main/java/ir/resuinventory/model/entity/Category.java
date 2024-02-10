package ir.resuinventory.model.entity;

import com.google.gson.Gson;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(name = "category_table")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "category_table_SEQ")
    @SequenceGenerator(
            name = "category_table_SEQ",
            sequenceName = "category_table_SEQ",
            allocationSize = 1,
            initialValue = 0)
    private long categoryId;

    private String categoryName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PARENTID")
    private Category parentId;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Product> products;

    public Category setProduct(Product product) {
        List<Product> productList = getProducts();
        productList.add(product);
        setProducts(productList);
        return this;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
