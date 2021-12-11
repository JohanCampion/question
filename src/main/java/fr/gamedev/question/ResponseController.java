package fr.gamedev.question;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.gamedev.question.data.Answer;
import fr.gamedev.question.data.UserAnswer;
import fr.gamedev.question.repository.AnswerRepository;
import fr.gamedev.question.repository.QuestionRepository;
import fr.gamedev.question.repository.UserAnswerRepository;

/**
 * @author djer1
 *
 */
@RestController
public class ResponseController {
	
	//repository
	private AnswerRepository answerRepository;
	private QuestionRepository questionRepository;
	private UserAnswerRepository userAnswerRepository;
	
	@Autowired
	public ResponseController(AnswerRepository answerRepository, QuestionRepository questionRepository, UserAnswerRepository userAnswerRepository) {
		this.answerRepository = answerRepository;
		this.questionRepository = questionRepository;
		this.userAnswerRepository = userAnswerRepository;
		
	}
	
	
	
	
	@GetMapping("/response")
	public String answer(@RequestParam long questionId, @RequestParam Boolean answer, @RequestParam long userId) {
	
		// Get the correct answer
		Optional<Answer> response =  answerRepository.findById(questionId);
		
		Boolean correctResponse = response.get().getCorrectAnswer();
		
		// start creating of entity userAnswerRepository
		UserAnswer userAnswer = new UserAnswer();
		userAnswer.setUserId(userId);
		
		// Check if response is correct
		if (answer == correctResponse) {
			userAnswer.setPoints(1);
		} 
		
		// add to database
		userAnswerRepository.save(userAnswer);
		
		return userAnswer.getPoints().toString();
		
	}

}
