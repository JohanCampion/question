package fr.gamedev.question.greeting;

/**
 * @author djer1
 *
 */
public class Greeting {
/**@param
*Identifiant
 */
private final long id;
/**@param
 * Contenu de la salutation
 */
private final String content;

public Greeting(final long id, final String content) {
	this.id = id;
	this.content = content;
}

public long getId() {
	return id;
}

public String getContent() {
	return content;
}
}
