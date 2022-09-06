package service;

import core.Author;
import dao.AuthorDao;
import dto.AuthorDto;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AuthorService {
   private  final AuthorDao authorDao;

    @Inject
    public AuthorService(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    public List<AuthorDto> getAllAuthors(){
        return authorDao.findAll().stream().map(this::convertAuthorEntityToDTO).collect(Collectors.toList());

    }

    public Optional<AuthorDto> findAuthorById(long id){
        return authorDao.getAuthorById(id).map(this::convertAuthorEntityToDTO);
    }

    public AuthorDto save(AuthorDto author){
        Author savedAuthor = (authorDao.save(convertDTOtoEntity(author)));
        return convertAuthorEntityToDTO(savedAuthor);
    }

    public Author saveDao(Author author){
        return authorDao.saveDao(author);

    }

    public AuthorDto convertAuthorEntityToDTO(Author author){
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getAuthorId());
        authorDto.setAuthorName(author.getAuthorName());
        authorDto.setEmail(author.getEmail());
        authorDto.setAge(author.getAge());
        return authorDto;
    }

    public Author convertDTOtoEntity(AuthorDto authorDto){
        Author author = new Author();
        author.setAuthorName(authorDto.getAuthorName());
        author.setAge(authorDto.getAge());
        author.setEmail(authorDto.getEmail());
        return author;
    }
}