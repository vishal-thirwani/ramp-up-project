import core.Author;
import core.Book;
import dao.AuthorDao;
import dao.BookDao;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import resources.AuthorResources;
import resources.BooksResource;

public class App extends Application<MyConfig> {
    private final HibernateBundle<MyConfig> hibernateBundle = new HibernateBundle<MyConfig>
            (Author.class, Book.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(MyConfig configuration) {
            return configuration.getDataSourceFactory();
        }
    };


    public static void main(String[] args) throws Exception {
        System.out.println("Starting......");
        new App().run(args);
    }

    public void initialize(Bootstrap<MyConfig> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
    }

    @Override
    public void run(MyConfig configuration, Environment environment) throws Exception {
        System.out.println("Running");

        final AuthorDao authorDAO = new AuthorDao(hibernateBundle.getSessionFactory());
        final BookDao bookDao = new BookDao(hibernateBundle.getSessionFactory());
        environment.jersey().register(new BooksResource(bookDao));
        environment.jersey().register(new AuthorResources(authorDAO));
    }
}
