package library.domain;

import java.util.*;
import library.domain.*;
import library.infra.AbstractEvent;
import lombok.*;

@Data
@ToString
public class BookCompleted extends AbstractEvent {

    private Long id;
    private String bookCover;
    private String summary;
    private Integer price;
}
