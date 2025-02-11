package id.putra.peoplelibrarysystem.entity;

import jakarta.persistence.*;
import lombok.Builder;

import java.io.Serializable;

@Entity
@Table(name = "users")
@Builder
public class User extends BaseEntity  {
    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private Role role;

    public User() {
        super();
    }
}
