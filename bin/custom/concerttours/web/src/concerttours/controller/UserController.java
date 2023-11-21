package concerttours.controller;

import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String getUser(Model model, @RequestParam(value = "uid", required = false) String uid) {
        UserModel user = null;
        if (uid != null && !uid.isBlank()) {
            user = userService.getUserForUID(uid);
        } else {
            user = userService.getCurrentUser();
        }
        model.addAttribute("user", user);

        return "user";
    }
}
