package id.putra.peoplelibrarysystem.entity;

import jakarta.persistence.*;
import lombok.Builder;

import java.io.Serializable;

@Entity
@Table(name = "address")
@Builder
public class Address implements Serializable {
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

    public Address() {
    }
}
