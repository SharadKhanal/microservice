package com.question.service;

import com.question.entities.Question;

import java.util.List;

public interface QuestionService {

    Question addQuestion(Question question);
    Question updateQuestion(Question question);
    void deleteQuestion(Question question);
    Question getQuestionById(Long questionId);
    List<Question> getAllQuestions();
    List<Question> getQuestionOfQuiz(Long quizId);

}
