import data.model.Book;
import data.repository.BookShelf;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Book test")
public class BookTest {
    Book effectiveJava;
    Book codeComplete;
    Book mythicalManMonth;
    Book cleanCode;
    Book refactoring;
    BookShelf<Book> bookShelf;

    @BeforeEach
    void init(){
        effectiveJava = new Book("Effective Java", "Joshua Bloch", LocalDate.of(2008, Month.MAY, 8));
        codeComplete = new Book("Code Complete", "Steve McConnel", LocalDate.of(2004, Month.JUNE, 9));
        mythicalManMonth = new Book("The Mythical Man-Month", "Frederick Phillips Brooks", LocalDate.of(1975, Month.JANUARY, 1));
        cleanCode = new Book("The clean Code", "Frederick Phillips Brooks", LocalDate.of(1975, Month.JANUARY, 1));
        refactoring = new Book("Refactoring", "Martin Fowler", LocalDate.of(2001, Month.NOVEMBER, 8));
        bookShelf = new BookShelf<>();
    }

    @Test
    @DisplayName("book shelf is empty no book is added")
    void emptyBookShelfWhenNoBookIsAdded(){
        List<Book> books = bookShelf.books();
        assertTrue(books.isEmpty());
    }

    @Test
    @DisplayName("book shelf contain two books")
    void canAddBookToShelf(){
        bookShelf.save(effectiveJava, codeComplete);
        List<Book> books = bookShelf.books();
        assertThat(books.size()).isEqualTo(2);
    }
}
