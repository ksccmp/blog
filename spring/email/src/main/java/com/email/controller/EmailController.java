package com.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private JavaMailSender javaMailSender;

    @PostMapping("/send")
    public ResponseEntity<Object> send() {
        // 이메일 발신될 데이터 적재
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo("{수신자 이메일 주소}");
        simpleMailMessage.setSubject("스프링으로 보내는 이메일 타이틀!");
        simpleMailMessage.setText("스프링으로 보내는 이메일 내용! \n" +
                                  "이런식으로 메일 내용이 전달됩니다!! \n" +
                                  "모두 스프링으로 메일을 전달해보세요!!!");

        // 이메일 발신
        javaMailSender.send(simpleMailMessage);

        // 결과 반환
        return ResponseEntity.ok(true);
    }
}
