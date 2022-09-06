package service;

import core.Book;
import dao.BookDao;
import dto.BookDto;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class BooksService {
    private final BookDao bookDao;

    @Inject
    public BooksService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public List<BookDto> findAll(){
        return bookDao.findAll().stream().map(this::convertBookEntityToDTO).collect(Collectors.toList());
    }

    public BookDto save(BookDto book){
        return convertBookEntityToDTO(bookDao.save((convertDTOtoEntity(book))));
    }

    public List<BookDto> getAuthorsBook(long id){
        return bookDao.getAuthorsBooks(id).stream().map(this::convertBookEntityToDTO).collect(Collectors.toList());
    }

    public BookDto convertBookEntityToDTO(Book book){
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getBookId());
        bookDto.setBookName(book.getBookName());
        bookDto.setPrice(book.getBookPrice());
        bookDto.setAuthorId(book.getAuthorId());
        return bookDto;
    }

    public Book convertDTOtoEntity(BookDto bookDto){
        Book book = new Book();
        book.setBookId(bookDto.getId());
        book.setBookName(bookDto.getBookName());
        book.setBookPrice(bookDto.getPrice());
        book.setAuthorId(bookDto.getAuthorId());
        return book;
    }
}