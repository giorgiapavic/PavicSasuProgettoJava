/**
 * 
 */
package it.univpm.progettoPavicSasu.Controller;

/**
 * @author Giorgia Pavic
 * @author Riccardo Sasu
 */
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
@RestController
public class APIController {

    @RequestMapping("/")
    public String home(){
        return "Hello World!";
    }

}