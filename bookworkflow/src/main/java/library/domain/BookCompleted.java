package library.domain;

import java.time.LocalDate;
import java.util.*;
import library.domain.*;
import library.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class BookCompleted extends AbstractEvent {

    private Long id;
    private String bookCover;
    private String summary;
    private Integer price;

    public BookCompleted() {
        super();
    }
}
//>>> DDD / Domain Event
