package pl.coderslab.budgetmanager.model.data;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "finance_values")
public class Value {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    

    @Column(columnDefinition = "integer default 0")
    private Long value;

    @Enumerated(value = EnumType.STRING)
    private Type type;

    @Column(name = "date")
    private LocalDate date = LocalDate.now();

    @NotEmpty
    @ManyToMany
    @JoinTable(name = "values_owners",
            joinColumns = @JoinColumn(name = "value_id"),
            inverseJoinColumns = @JoinColumn(name = "owner_id"))
    private List<Owner> owners = new ArrayList<>();

    @Enumerated(value = EnumType.STRING)
    private Category category;

    @Override
    public String toString() {
        return "Value{" +
                "Id=" + Id +
                ", value=" + value +
                ", type=" + type +
                ", date=" + date +
                ", owners=" + owners +
                "}";
    }

}
