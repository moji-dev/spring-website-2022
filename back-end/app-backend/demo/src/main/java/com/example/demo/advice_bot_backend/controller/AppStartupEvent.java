package com.example.demo.advice_bot_backend.controller;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import com.example.demo.advice_bot_backend.repository.QuestionsRepository;
import com.example.demo.advice_bot_backend.model.Questions;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    private final QuestionsRepository questionsRepository;

    public AppStartupEvent(QuestionsRepository questionsRepository){
        this.questionsRepository = questionsRepository;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event){
        Iterable<Questions> questions = this.questionsRepository.findAll();
        questions.forEach(System.out::println);
    }

}