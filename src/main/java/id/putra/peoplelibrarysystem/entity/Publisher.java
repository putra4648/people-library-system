package id.putra.peoplelibrarysystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Entity
@Table(name = "publishers")
@SuperBuilder
@Getter
@NoArgsConstructor
@AllArgsConstructor
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
