package jpabook2.jpashop2.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
public class Category extends hellojpa.BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name ="PARENT_ID") // 잘 모르겠다.
    private Category parent;

    @OneToMany(mappedBy = "parent") // 잘 모르겠다.
    private List<Category> child = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "CATEGORY_ITEM", joinColumns = @JoinColumn(name = "CATEGORT_ID"),
    inverseJoinColumns = @JoinColumn(name = "ITEM_ID"))
    private List<Item> items = new ArrayList<>();
}
