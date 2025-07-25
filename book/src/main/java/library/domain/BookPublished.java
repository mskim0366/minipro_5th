package library.domain;

import java.time.LocalDate;
import java.util.*;
import library.domain.*;
import library.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class BookPublished extends AbstractEvent {

    private Long id;
    private Boolean isBookPublished;

    public BookPublished(Book aggregate) {
        super(aggregate);
    }

    public BookPublished() {
        super();
    }
}
//>>> DDD / Domain Event
