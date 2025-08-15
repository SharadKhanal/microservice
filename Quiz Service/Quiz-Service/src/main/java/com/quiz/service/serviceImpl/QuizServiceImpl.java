package com.quiz.service.serviceImpl;

import com.quiz.entities.Quiz;
import com.quiz.repos.QuizRepository;
import com.quiz.service.QuestionClient;
import com.quiz.service.QuizService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;
    private final QuestionClient questionClient;

    public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
        this.quizRepository = quizRepository;
        this.questionClient = questionClient;
    }

    @Override
    public Quiz saveQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> getAllQuiz() {

        List<Quiz> quizList = quizRepository.findAll();

        List<Quiz> newQuizList = quizList.stream().map(quiz->{
            quiz.setQuestions(questionClient.getQuestion(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());
        return newQuizList;
    }

    @Override
    public Quiz getQuizById(Long id) {


        Quiz quiz= quizRepository.findById(id).orElseThrow(()-> new RuntimeException("Quiz with id " + id + " not found"));

        quiz.setQuestions(questionClient.getQuestion(quiz.getId()));
        return quiz;
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {

        Optional<Quiz> quizOptional = quizRepository.findById(quiz.getId());

        if (quizOptional.isPresent()) {
            Quiz updatedQuiz = quizRepository.save(quiz);
            return updatedQuiz;
        }
        return null;
    }

    @Override
    public void deleteQuiz(Long id) {
       Optional<Quiz> quizOptional = quizRepository.findById(id);
       if (quizOptional.isPresent()) {
           quizRepository.deleteById(id);
       }
    }
}
