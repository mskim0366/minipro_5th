package library.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import library.config.kafka.KafkaProcessor;
import library.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class AuthorListViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private AuthorListRepository authorListRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenAuthorApproved_then_CREATE_1(
        @Payload AuthorApproved authorApproved
    ) {
        try {
            if (!authorApproved.validate()) return;

            // view 객체 생성
            AuthorList authorList = new AuthorList();
            // view 객체에 이벤트의 Value 를 set 함
            authorList.setId(authorApproved.getId());
            authorList.setName(authorApproved.getName());
            authorList.setDesciption(authorApproved.getDescription());
            authorList.setPortfolio(
                String.valueOf(authorApproved.getPortfolio())
            );
            authorList.setCreatedAt(authorApproved.getCreatedAt());
            authorList.setUpdatedAt(authorApproved.getUpdatedAt());
            // view 레파지 토리에 save
            authorListRepository.save(authorList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenAuthorRejected_then_DELETE_1(
        @Payload AuthorRejected authorRejected
    ) {
        try {
            if (!authorRejected.validate()) return;
            // view 레파지 토리에 삭제 쿼리
            authorListRepository.deleteById(authorRejected.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
