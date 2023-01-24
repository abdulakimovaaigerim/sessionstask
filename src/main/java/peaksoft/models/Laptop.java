package peaksoft.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.enums.OperationSystem;


@Entity
@Getter @Setter
@NoArgsConstructor
@Table(name = "laptops")
public class Laptop {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "programmer_id_generator")
    @SequenceGenerator(
            name = "programmer_id_generator",
            sequenceName = "programmer_seq",
            allocationSize = 1)

    private Long id;
    private String brand;
    @Enumerated(EnumType.STRING)
    private OperationSystem operationSystem;
    private int memory;
    private int price;

    @Column(name = "date_of_issue")
    private String dateOfIssue;

    public Laptop(String brand, OperationSystem operationSystem, int memory, int price, String dateOfIssue) {
        this.brand = brand;
        this.operationSystem = operationSystem;
        this.memory = memory;
        this.price = price;
        this.dateOfIssue = dateOfIssue;
    }

    @Override
    public String toString() {
        return "Laptops{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", operationSystem=" + operationSystem +
                ", memory=" + memory +
                ", price=" + price +
                ", dateOfIssue=" + dateOfIssue +
                '}';
    }
}
