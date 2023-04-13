/*
 * Der IndexController dient dazu, deine Hauptseiten zu steuern. Hier erstellst du entsprechende Links für die einzelnen Unterseiten. Später werden aber noch andere Controller dazukommen, um Daten zu verwalten.
 *
 */
package gymhum.de;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import gymhum.de.model.User;

@Controller
public class UserController {
   User user;
   public UserController() {
      // Instantiate new User model for the controller for default values in the template
      this.user = new User(
         "",
         "",
         LocalDate.now().toString(),
         "",
         0,
         false
      );
   }

   // https://howtodoinjava.com/spring5/webmvc/controller-getmapping-postmapping/
   // The @GetMapping annotation is a composed version of @RequestMapping annotation
   // that acts as a shortcut for @RequestMapping(method = RequestMethod.GET)
   @GetMapping("/userForm")
   public String showForm(Model model) {
      // Set user as active page
      model.addAttribute("activePage", "user");
      // Pass empty user model to the "user" page that we have access to the properties of User Model
      model.addAttribute("user", this.user);

      return "index.html";
   }

   // https://howtodoinjava.com/spring5/webmvc/controller-getmapping-postmapping/
   // The @PostMapping is a specialized version of @RequestMapping annotation
   // that acts as a shortcut for @RequestMapping(method = RequestMethod.POST)
   @PostMapping("/userForm")
   public String checkForm(@Valid User user, BindingResult bindingResult, Model model) {
      // Set active page
      model.addAttribute("activePage", "userResult");

      // Check for filled out user details, if there is an error, set the active page to "user" instead
      // of userResult
      if (bindingResult.hasErrors())
         model.addAttribute("activePage", "user");

      // Return the index.html to extend it with the active page template
      return "index.html";
   }
}