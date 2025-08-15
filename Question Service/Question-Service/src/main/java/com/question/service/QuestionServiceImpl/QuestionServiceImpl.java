package com.question.service.QuestionServiceImpl;

import com.question.entities.Question;
import com.question.repos.QuestionRepository;
import com.question.service.QuestionService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        Optional<Question> questionOptional = questionRepository.findById(question.getId());
        if (questionOptional.isPresent()) {
//            Question question1 = questionOptional.get();
            return questionRepository.save(question);
        }
       return null;
    }

    @Override
    public void deleteQuestion(Question question) {
        Optional<Question> questionOptional = questionRepository.findById(question.getId());
        if (questionOptional.isPresent()) {
            questionRepository.delete(question);
        }
    }

    @Override
    public Question getQuestionById(Long questionId) {
        return questionRepository.findById(questionId).orElseThrow(()-> new RuntimeException("Question not found with id: " + questionId));
    }

    @Override
    @Cacheable(value ="allQuestions",key = "'questions'")
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public List<Question> getQuestionOfQuiz(Long quizId) {
        return questionRepository.findByQuizid(quizId);
    }
}
