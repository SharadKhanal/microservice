package com.quiz.service;

import com.quiz.entities.Quiz;

import java.util.List;

public interface QuizService {

    Quiz  saveQuiz(Quiz quiz);
    List<Quiz> getAllQuiz();
    Quiz getQuizById(Long id);
    Quiz updateQuiz(Quiz quiz);
    void deleteQuiz(Long id);
}
