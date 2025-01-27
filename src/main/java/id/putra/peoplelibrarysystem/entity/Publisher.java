package id.putra.peoplelibrarysystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table
@Data
public class Publisher extends BaseEntity {
    @Id
    @Column(name = "publisher_id", nullable = false)
    private String publisherId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "year", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date year;

    @ManyToOne
    @JoinColumn(name = "isbn")
    private Book book;
}
