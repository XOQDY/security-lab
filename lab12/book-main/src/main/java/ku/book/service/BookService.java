package ku.book.service;

import ku.book.dto.BookDto;
import ku.book.model.Book;
import ku.book.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public List<BookDto> getAllBook() {
        List<Book> books = repository.findAll();

        List<BookDto> dtos = books
                .stream()
                .map(book -> modelMapper.map(book, BookDto.class))
                .collect(Collectors.toList());
        return dtos;
    }

    public void create(BookDto bookDto) {
        Book book = modelMapper.map(bookDto, Book.class);
        book.setCreatedAt(Instant.now());
        repository.save(book);
    }
}
