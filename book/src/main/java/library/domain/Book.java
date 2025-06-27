package library.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import library.BookApplication;
import library.domain.BookPublished;
import library.domain.BookViewed;
import library.domain.CreatedPost;
import library.domain.PointLacked;
import lombok.Data;

@Entity
@Table(name = "Book_table")
@Data
//<<< DDD / Aggregate Root
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @Lob
    private String content;

    private Long viewCount;

    private Date createdAt;

    private Date updatedAt;

    private Boolean isBookPublished;

    private Integer price;

    @Embedded
    private File bookCover;

    private String summary;

    private Long bookReleaseAdminId;

    private Long authorId;

    private Boolean isBestseller;

    @PostPersist
    public void onPostPersist() {
        CreatedPost createdPost = new CreatedPost(this);
        createdPost.publishAfterCommit();

        BookViewed bookViewed = new BookViewed(this);
        bookViewed.publishAfterCommit();

        BookPublished bookPublished = new BookPublished(this);
        bookPublished.publishAfterCommit();

        PointLacked pointLacked = new PointLacked(this);
        pointLacked.publishAfterCommit();
    }

    public static BookRepository repository() {
        BookRepository bookRepository = BookApplication.applicationContext.getBean(
            BookRepository.class
        );
        return bookRepository;
    }

    //<<< Clean Arch / Port Method
    public static void publishBook(BookCompleted bookCompleted) {
        //implement business logic here:

        /** Example 1:  new item 
        Book book = new Book();
        repository().save(book);

        BookPublished bookPublished = new BookPublished(book);
        bookPublished.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(bookCompleted.get???()).ifPresent(book->{
            
            book // do something
            repository().save(book);

            BookPublished bookPublished = new BookPublished(book);
            bookPublished.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
