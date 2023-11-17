package com.alexonic.mvc.controller;

import com.alexonic.mvc.model.Book;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Objects;

@Controller
public class BookController {
    ArrayList<Book> arrayList;

    BookController() {
        Book book1 = Book.builder()
                .id(1)
                .isbn(100001)
                .author("Robert T. Kiyosaki")
                .price(15.99)
                .title("Rich Dad Poor Dad")
                .year("1997")
                .build();

        Book book2 = Book.builder()
                .id(2)
                .isbn(100002)
                .author("Napoleon Hill")
                .price(9.75)
                .title("Think and Grow Rich")
                .year("1937")
                .build();

        Book book3 = Book.builder()
                .id(3)
                .isbn(100003)
                .author("Stephen Covey")
                .price(11.99)
                .title("The 7 Habits")
                .year("1989")
                .build();

        Book book4 = Book.builder()
                .id(4)
                .isbn(100004)
                .author("The Secret")
                .price(10.00)
                .title("Rhonda Byrne")
                .year("2006")
                .build();

        arrayList = new ArrayList<>();
        arrayList.add(book1);
        arrayList.add(book2);
        arrayList.add(book3);
        arrayList.add(book4);
    }

    @GetMapping("/book")
    public String bookPage(ModelMap md) {
        md.addAttribute("books", arrayList);
        return "book/book";
    }

    @GetMapping("/homework")
    public String newIndexPage() {
        return "/homework/homework";
    }

    @GetMapping("/book/{id}")
    public String bookDetailPage(@PathVariable Integer id, @RequestParam(defaultValue = "00000000") Integer isbn, ModelMap md) {
        for (Book book : arrayList) {
            if (Objects.equals(book.getId(), id)) {
                md.addAttribute("book", book);
            }
        }
        return "book/bookdetail";
    }

    @GetMapping("/child")
    public String childTestPage() {
        return "childtest/childtest";
    }

    @GetMapping("/table")
    public String tablePage(ModelMap md) {
        md.addAttribute("books", arrayList);
        md.addAttribute("isTable", true);
        return "book/table";
    }

    @GetMapping("/book/create")
    public String createPage(Book book, ModelMap md) {
        md.addAttribute(book);
        return "book/create";
    }

    @PostMapping("/book/save")
    public String save(@Valid Book book, BindingResult br) {
        if (br.hasErrors()) {
            return "book/create";
        }

        book.setId(arrayList.size() + 1);
        arrayList.add(book);
        return "redirect:/book";
    }
}
