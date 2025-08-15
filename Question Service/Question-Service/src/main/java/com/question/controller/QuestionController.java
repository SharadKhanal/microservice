package com.question.controller;

import com.question.entities.Question;
import com.question.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

   @PostMapping
    public Question addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
   }
   @PutMapping("/update-question")
    public Question updateQuestion(@RequestBody Question question) {
        return questionService.updateQuestion(question);
   }

   @GetMapping("/getById/{id}")
   public ResponseEntity<Question> getQuestionById(@PathVariable Long id) {
        return ResponseEntity.ok(questionService.getQuestionById(id));
   }

   @GetMapping("/all")
    public ResponseEntity<List<Question>> getAllQuestion() {
        return ResponseEntity.ok(questionService.getAllQuestions());
   }
   @GetMapping("/quizQuestion/{id}")
    public ResponseEntity<List<Question>> getQuizQuestion(@PathVariable Long id) {
        return ResponseEntity.ok(questionService.getQuestionOfQuiz(id));
   }
}
