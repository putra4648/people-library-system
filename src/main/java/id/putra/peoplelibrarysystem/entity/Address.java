package id.putra.peoplelibrarysystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "address")
@SuperBuilder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String city;

    private String street;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "full_address")
    private String fullAddress;

    @OneToOne(mappedBy = "address")
    private User user;
}
