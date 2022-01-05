package fr.gamedev.question;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author djer1
 *
 */

//TODO grp1 by DJE : CheckStyle : votre fichier de conf était à priori mauvais. Je vous propose une modification.
//TODO grp1 by DJE : CheckStyle : il faut configurer votre formateur de code (les inedntation doivent être des espaces). Il faut ensuite faire une modification puis "foralmtter le code" sur CHAQUE fichier.
//TODO grp1 by DJE : CheckStyle : plusieurs JavaDoc manquantes (ils seront visibles avec la bonne configuration de CheckStyle)

//@SuppressWarnings({ "checkstyle:HideUtilityClassConstructor" })
@SpringBootApplication
public class Launcher {

    /**
     * @param args command line params
     */
    public static void main(final String[] args) {
        SpringApplication.run(Launcher.class, args);
    }

}
