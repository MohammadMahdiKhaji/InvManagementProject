package ir.resuinventory.model.entity;

import com.google.gson.Gson;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlTransient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnTransformer;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor


@Entity
@Table(name = "product_table")
@SqlResultSetMapping(
        name = "ProductMapping",
        classes= {
                @ConstructorResult(
                        targetClass = Product.class,
                        columns = {
                                @ColumnResult(name = "productId"),
                                @ColumnResult(name = "productName"),
                                @ColumnResult(name = "categoryId")
                        }
                )
        }
)

public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "product_table_SEQ")
    @SequenceGenerator(
            name = "product_table_SEQ",
            sequenceName = "product_table_SEQ",
            allocationSize = 1)
    private long productId;

    private String productName;

    @Transient
    private long categoryId;

    @Transient
    private String categories;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
