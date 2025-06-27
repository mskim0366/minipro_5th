package library.domain;

import java.time.LocalDate;
import java.util.*;
import library.domain.*;
import library.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class BookViewed extends AbstractEvent {

    private Long id;
    private Long memberId;
    private Integer price;

    public BookViewed(Book aggregate) {
        super(aggregate);
    }

    public BookViewed() {
        super();
    }
}
//>>> DDD / Domain Event
