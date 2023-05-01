package ku.book.controller;

import ku.book.dto.BookDto;
import ku.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping("/book")
    public String getBookPage(Model model) {
        model.addAttribute("books", service.getAllBook());
        return "book";
    }

    @GetMapping("/book/add")
    public String getAddPage() {
        return "book-add";
    }


    @PostMapping("/book/add")
    public String addBook(@ModelAttribute BookDto book,
                          Model model) {
        service.create(book);
        return "redirect:/book";
    }

}
