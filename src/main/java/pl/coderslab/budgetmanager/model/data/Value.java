package pl.coderslab.budgetmanager.model.data;


import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "values")
public class Value {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotEmpty
    @Column(name = "value")
    private Long value;

    @NotEmpty
    @Column(name = "type")
    @ElementCollection
    private List<String> type;

    @NotEmpty
    @Column(name = "date")
    private SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");

    @NotEmpty
    @ManyToMany
    @JoinTable(name = "values_owners",
            joinColumns = @JoinColumn(name = "value_id"),
            inverseJoinColumns = @JoinColumn(name = "owner_id"))
    private List<Owner> owners = new ArrayList<>();

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
