package resources;

import responses.ErrorResponse;
import dao.BookDao;
import dto.BookDto;
import io.dropwizard.hibernate.UnitOfWork;
import service.BooksService;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/book")
public class BooksResource {

    private BooksService booksService;

    public BooksResource(BookDao bookDao) {
        this.booksService = new BooksService(bookDao);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all-books")
    @UnitOfWork
    public Response getAllBooks(){
        List<BookDto> books = booksService.findAll();
        return Response.accepted(books).status(200).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @UnitOfWork
    public Response saveBook(@Valid BookDto book)
    {
        BookDto savedBook = booksService.save(book);
        return Response.accepted(savedBook).status(200).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/author-id/{authorid}")
    @UnitOfWork
    public Response getBooksByAuthorId(@PathParam("authorid") int id){
        List<BookDto> authorBooks= booksService.getAuthorsBook(id);

        if(authorBooks.isEmpty()){
            ErrorResponse err = new ErrorResponse();
            err.setMsg("No such author found");
            err.setStatusCode(400);
            return Response.status(400).entity(err).build();}
        else
            return Response.accepted(authorBooks).status(200).build();
    }

}