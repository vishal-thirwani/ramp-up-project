package service;


import dao.AuthorDao;
import dto.AuthorDto;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class AuthorServiceTest {

    @Mock
    private AuthorDao mockAuthorDao;

    @InjectMocks
    private AuthorService authorService;

    @Test
    public void getAllAuthorsTest(){
        AuthorDto authorDto = new AuthorDto();
        List<AuthorDto> authorDtoList =new ArrayList<>();
        authorDtoList.add(authorDto);
         Mockito.when(mockAuthorDao.findAll()).thenReturn(authorDtoList);
    }

}
