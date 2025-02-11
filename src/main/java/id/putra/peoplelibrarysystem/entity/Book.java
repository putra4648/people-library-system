package id.putra.peoplelibrarysystem.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "books")
@SuperBuilder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Book extends BaseEntity {
    @Id
    @Column(name = "isbn", nullable = false)
    private String isbn;

    private String title;

    private String edition;

    private Long price;

    @OneToMany(mappedBy = "book", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Category> categories;

    @OneToMany(mappedBy = "book", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Author> authors;

    @OneToMany(mappedBy = "book", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Publisher> publishers;

}
