package capston.thecloset.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
public class Category {

    @Id @GeneratedValue
    @Column(name="category_id")
    private Long id;

    @OneToMany(mappedBy = "category")
    private List<Item> itemList = new ArrayList<>();
}
