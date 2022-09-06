package core;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name="author")

@NamedQueries({
        @NamedQuery(
                name = "core.Author.findAll",
                query = "SELECT a FROM Author a"
        )
})

@Getter
@Setter
@NoArgsConstructor
public class Author {

    public Author(int authorId, String authorName, int age, String email) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.age = age;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="author_id", nullable = false)
    private int authorId;

    @Column(name="author_name", nullable = false)
    private String authorName;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "email", nullable = false)
    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name="author_book" , joinColumns = {@JoinColumn(name="author_id")} , inverseJoinColumns = {@JoinColumn(name="book_id")})
    private List<Book> authorBooks = new ArrayList<>();

    public List<Book> getAuthorBooks() {
        return this.authorBooks;
    }

    public void setAuthorBooks(List<Book> authorBooks) {
        this.authorBooks = authorBooks;
    }
}