package id.putra.peoplelibrarysystem.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "authors")
@Builder
public class Author extends BaseEntity {
    @Id
    @Column(name = "author_id", nullable = false)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "year", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date year;

    @ManyToOne
    @JoinColumn(name = "isbn")
    private Book book;

    public Author() {
        super();
    }
}
