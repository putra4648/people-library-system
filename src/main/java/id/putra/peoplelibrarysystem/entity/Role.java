package id.putra.peoplelibrarysystem.entity;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Table(name = "user_role")
@Builder
public class Role  {
    @Id
    @Column(name = "role_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne(mappedBy = "role")
    private User user;

    public Role() {
    }


}
