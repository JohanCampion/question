package fr.gamedev.question.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author djer1
 *
 */
@Entity
public class Answer {

	/**@param
	 *Identifiant, autogénéré
	 */
	@GeneratedValue
	@Id
	private long id;
	/**@param
	 * Question liée à la réponse
	 */
	@OneToOne
	private Question question;
	/**@param
	 * Boolean : la réponse est-elle correcte ?
	 */
	private Boolean correctAnswer;
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(final long id) {
		this.id = id;
	}
	/**
	 * @return the question
	 */
	public Question getQuestion() {
		return question;
	}
	/**
	 * @param question the question to set
	 */
	public void setQuestion(Question question) {
		this.question = question;
	}
	/**
	 * @return the correctAnswer
	 */
	public Boolean getCorrectAnswer() {
		return correctAnswer;
	}
	/**
	 * @param correctAnswer the correctAnswer to set
	 */
	public void setCorrectAnswer(Boolean correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

}
