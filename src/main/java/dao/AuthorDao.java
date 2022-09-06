package dao;

import core.Author;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

public class AuthorDao extends AbstractDAO<Author> {
    @Inject
    public AuthorDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

        //external call
    public List<Author> findAll(){
        return list((Query<Author>) namedQuery("core.Author.findAll"));
    }

    public Optional<Author> getAuthorById(long id){
        System.out.println(Optional.ofNullable(get(id)));
        return Optional.ofNullable(get(id));
    }

    public Author save(Author author) {
        this.persist(author);
        return author;
    }

    public Author saveDao(Author author) {
        this.persist(author);
        return author;
    }
}