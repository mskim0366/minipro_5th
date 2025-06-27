package library.domain;

import java.time.LocalDate;
import java.util.*;
import library.domain.*;
import library.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class PointLacked extends AbstractEvent {

    private Long id;

    public PointLacked(Book aggregate) {
        super(aggregate);
    }

    public PointLacked() {
        super();
    }
}
//>>> DDD / Domain Event
