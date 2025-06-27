package library.domain;

import java.time.LocalDate;
import java.util.*;
import library.domain.*;
import library.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class PointConsumed extends AbstractEvent {

    private Long id;
    private Integer pointBalance;

    public PointConsumed(User aggregate) {
        super(aggregate);
    }

    public PointConsumed() {
        super();
    }
}
//>>> DDD / Domain Event
