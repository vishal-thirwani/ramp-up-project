package dao;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import core.Book;

import javax.inject.Inject;
import java.util.List;

public class BookDao extends AbstractDAO<Book> {
    @Inject
    public BookDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<Book> findAll(){
        return list((Query<Book>) namedQuery("core.Book.findAll"));
    }

    public Book save(Book book) {
        this.persist(book);
        return book;
    }

    public List<Book> getAuthorsBooks(Long id) {
        return this.list(this.namedTypedQuery("core.Book.booksOfAuthor").setParameter("id", id));
    }
}