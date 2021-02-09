package com.app.books.bootstrap;

import com.app.books.domain.Book;
import com.app.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BooksDataBootstrap implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        if (bookRepository.count() == 0) {
            loadBooks();
        }
    }

    private void loadBooks() {
        Book book1 = Book.builder().author("Robert").title("Rich Dad Poor Dad").build();
        Book book2 = Book.builder().author("Napolean").title("Think & Grow Rich").build();
        Book book3 = Book.builder().author("J.K. Rowlingg").title("Harry Potter and Chamber of Secrets").build();

        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
    }
}
