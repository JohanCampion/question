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
    //TODO grp1 by DJE : PMD : Pmd indique que cet attributs est inutilisé.
    private QuestionRepository questionRepository;
    private UserAnswerRepository userAnswerRepository;

    @Autowired
    public ResponseController(AnswerRepository answerRepository, QuestionRepository questionRepository,
            UserAnswerRepository userAnswerRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
        this.userAnswerRepository = userAnswerRepository;

    }

    //TODO grp1 by DJE : REST : devrait renvoyer du "HAL" (paramètre produces = "application/hal+json")
    @GetMapping("/response")
    public String answer(@RequestParam long questionId, @RequestParam Boolean answer, @RequestParam long userId) {

        //TODO grp1 by DJE : POO : le paramètre "questionId" devrait s'appeler "answerId". Ca n'estp as une bonne idée d'exposer cette valeur il faudrait un "findByQuestionId" dans le QuestionRepository.
        // Get the correct answer
        Optional<Answer> response = answerRepository.findById(questionId);

        Boolean correctResponse = response.get().getCorrectAnswer();

        //TODO grp1 by DJE : Besoin : il FAUT vérifier que l'utilisateur répond à une question POSEE. Pour poser une question créez un userAnswer (via Postman) avec nbPoint à null, puis vérifiez que l'utilisateur possède bien une question posée avec l'ID de la question OU modifiez l'API pour que l'ID à fournir soit un id de "UserAnswer".
        // start creating of entity userAnswerRepository
        UserAnswer userAnswer = new UserAnswer();
        userAnswer.setUserId(userId);

        // Check if response is correct
        if (answer == correctResponse) {
            //TODO grp1 by DJE : POO : le nombre de points devrait être une constante.
            userAnswer.setPoints(1);
        }
        //TODO grp1 by DJE : Algo : si l'utilisateur fourni une réponse érronnée, le nombr de point rest à "null" (ce qui corespond à une question NON répondues). Je peux gagner de milloin de points en appuyant sur F5" après avoir répondu UNE SEUL FOIS correct à UNE question.

        // add to database
        userAnswerRepository.save(userAnswer);

        return userAnswer.getPoints().toString();

    }

}
