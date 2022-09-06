package resources;

import dao.AuthorDao;
import dto.AuthorDto;
import io.dropwizard.hibernate.UnitOfWork;
import responses.ErrorResponse;
import service.AuthorService;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/author")
public class  AuthorResources {

    private  AuthorService authorService;
    public AuthorResources(AuthorDao authorDao) {
        this.authorService = new AuthorService(authorDao);
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all-authors")
    @UnitOfWork
    public Response getAllAuthors() {
        List<AuthorDto> authors = authorService.getAllAuthors();
        System.out.println(authors);
        return Response.accepted(authors).status(200).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @Path("/{id}")
    public Response getAuthorById(@PathParam("id") int id) {
        final Optional<AuthorDto> result = authorService.findAuthorById(id);
        ErrorResponse err = new ErrorResponse();
        err.setMsg("Author with id value " + id + " does not exist");
        err.setStatusCode(400);
        if(result.isPresent()) {
            return Response.status(200).entity(result.get()).build();
        }
        else {
            return Response.status(400).entity(err).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @UnitOfWork
    public Response saveAuthor(@Valid AuthorDto author) {
        AuthorDto savedAuthor = authorService.save(author);
        try {
            return Response.status(200).entity(savedAuthor).build();
        }
        catch (Exception e) {
            return Response.status(400).entity(e).build();
        }
    }
}