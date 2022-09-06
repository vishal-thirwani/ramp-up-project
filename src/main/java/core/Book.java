package core;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name="book")

@NamedQueries({
        @NamedQuery(
                name = "core.Book.findAll",
                query = "SELECT a FROM Book a"
        ),
        @NamedQuery(
                name = "core.Book.booksOfAuthor",
                query = "Select b from Book b , Author a WHERE a.authorId = b.authorId and a.authorId= :id"
        )
})

@Getter
@Setter
@NoArgsConstructor
public class Book {

    public Book(int bookId, String bookName, int bookPrice, int authorId) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.authorId = authorId;
    }

    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;
    @Column(name = "book_name")
    private String bookName;

    @Column(name = "book_price")
    private int bookPrice;

    @Column(name = "author_id")
    private int authorId;
}