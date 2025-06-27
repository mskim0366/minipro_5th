package library.domain;

import java.time.LocalDate;
import java.util.*;
import library.domain.*;
import library.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class CreatedPost extends AbstractEvent {

    private Long authorId;
    private String name;
    private String title;
    private String content;

    public CreatedPost(Book aggregate) {
        super(aggregate);
    }

    public CreatedPost() {
        super();
    }
}
//>>> DDD / Domain Event
