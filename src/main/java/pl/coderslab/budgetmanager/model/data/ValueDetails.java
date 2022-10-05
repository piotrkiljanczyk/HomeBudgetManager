package pl.coderslab.budgetmanager.model.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.text.SimpleDateFormat;

@Getter
@Setter
@Entity
@Table(name = "values_details")
public class ValueDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer value;

    private String firstName;

    private String lastName;

    private String category;

    private String type;

    private SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");

}
