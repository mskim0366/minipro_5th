package library.infra;

import library.domain.*;
import library.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class BookInfoViewHandler {

//<<< DDD / CQRS
    @Autowired
    private BookInfoRepository bookInfoRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void when_then_CREATE_ (@Payload  ) {
        try {

            if (!.validate()) return;

            // view 객체 생성
            BookInfo bookInfo = new BookInfo();
            // view 객체에 이벤트의 Value 를 set 함
            bookInfo.setId(.getId());
            bookInfo.set();
            // view 레파지 토리에 save
            bookInfoRepository.save(bookInfo);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void when_then_UPDATE_(@Payload  ) {
        try {
            if (!.validate()) return;
                // view 객체 조회

                List<BookInfo> bookInfoList = bookInfoRepository.findBy();
                for(BookInfo bookInfo : bookInfoList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    bookInfo.set();
                // view 레파지 토리에 save
                bookInfoRepository.save(bookInfo);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }


//>>> DDD / CQRS
}

