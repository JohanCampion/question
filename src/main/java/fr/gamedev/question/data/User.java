package fr.gamedev.question.data;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * @author djer1
 *
 */
@Entity
public class User {

    //TODO grp1 by DJE : JavaDoc : @param est inutile ici.
    /**@param
     *Identifiant, autogénéré
     */
    @GeneratedValue
    @Id
    private long id;
    /**@param
     *Nom d'utilisateur (pour la connection par exemple)
     */
    private String login;
    /**@param
     *Nom de famille (pour l'affichage)
     */
    private String lastName;

    //TODO grp1 by DJE : PMD : Pmd indique que cet attributs est inutilisé (il manque les getter/setters)
    @ManyToMany
    private List<Tag> interets;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
