package library.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import library.config.kafka.KafkaProcessor;
import library.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    UserRepository userRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='BookViewed'"
    )
    public void wheneverBookViewed_ConsumePoints(
        @Payload BookViewed bookViewed
    ) {
        BookViewed event = bookViewed;
        System.out.println(
            "\n\n##### listener ConsumePoints : " + bookViewed + "\n\n"
        );

        // Sample Logic //
        User.consumePoints(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
