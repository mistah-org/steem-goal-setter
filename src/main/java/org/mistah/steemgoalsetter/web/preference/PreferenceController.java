package org.mistah.steemgoalsetter.web.preference;

import java.util.Map;

import org.mistah.steemgoalsetter.model.admin.SystemUser;
import org.mistah.steemgoalsetter.model.admin.UserPreference;
import org.mistah.steemgoalsetter.repository.UserRepository;
import org.mistah.steemgoalsetter.security.CustomUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PreferenceController {

    private final Logger logger = LoggerFactory.getLogger(PreferenceController.class);

    @Autowired
    private UserRepository userRepo;

    @RequestMapping(value = "/preference", method = RequestMethod.GET)
    public String index(Map<String, Object> model) {
        return "preference/index";
    }

    @RequestMapping(value = "/preference/notification", method = RequestMethod.GET)
    public String notification(Map<String, Object> model) {
       UserPreference userPreference = null;
       Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       if (principal instanceof CustomUserDetails) {
           SystemUser user = ((CustomUserDetails)principal).getUser();
           userPreference = user.getPreference();
           if (userPreference == null) {
               userPreference = new UserPreference();
               user.setPreference(userPreference);
               userRepo.save(user);
           }
       }
       model.put("preference", userPreference);

        return "preference/notification";
    }

    @RequestMapping(value = "/preference/notification", method = RequestMethod.POST)
    public String notification(
            @RequestParam(name="enableNotification") boolean enableNotification,
            Map<String, Object> model) {

        UserPreference userPreference = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof CustomUserDetails) {
            SystemUser user = ((CustomUserDetails) principal).getUser();
            userPreference = user.getPreference();
            userPreference.setEnableNotification(enableNotification);
            user.setPreference(userPreference);
            userRepo.save(user);
        }

        return "redirect:/preference/notification";
    }

}