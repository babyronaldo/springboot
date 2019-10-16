package springboot.hibernate.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import springboot.hibernate.entity.Role;
import springboot.hibernate.entity.User;
import springboot.hibernate.service.RoleService;
import springboot.hibernate.service.UserService;

@EnableWebMvc
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("userList", userService.findAll());
        return "userPage";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());

        return "userAdd";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute(value = "user") @Valid User user,
                      BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "userAdd";
        } else if (userService.findUserByUserName(user.getUsername()) != null) {
            redirectAttributes.addFlashAttribute("message", "Your username is already exist!!!");
            return "redirect:/user/add";
        } else {
            Role role =  roleService.find(3);
            user.setRole(role);
            user.setRoleId(role.getRoleId());
            userService.create(user);
            redirectAttributes.addFlashAttribute("message", "Add User Successful!!!");
            return "redirect:/user/index";
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable(value = "id") int id, final RedirectAttributes redirectAttributes) {

        if (userService.find(id) == null) {
            return "redirect:/403.html";
        } else
            userService.remove(id);
        redirectAttributes.addFlashAttribute("message", "User has been deleted successful!");
        return "redirect:/user/index";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable(value = "id") int id, ModelMap modelMap) {

        modelMap.addAttribute("user", userService.find(id));
        if (userService.find(id) == null) {
            return "redirect:/403.html";
        }
        return "userEdit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute(value = "user") @Valid User user,
                       BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {

            return "userEdit";
        } else {
            userService.edit(user);
            redirectAttributes.addFlashAttribute("message", "Edit User Successful!!!");
            return "redirect:/user/index";
        }
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.GET)
    private String changepass(ModelMap mm, HttpServletRequest rq) {

//        ChangePass changePass = new ChangePass();
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String name = auth.getName();
        User user = this.userService.findUserByUserName("admin");

//        changePass.setUsername(interviewer.getUsername());

//        mm.addAttribute("changePassword", changePass);
        return "changePassword";

    }

//    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
//    private String changePassword(ModelMap modelMap,
//                                  @ModelAttribute(value = "changePassword") @Valid ChangePass changePass, BindingResult bindingResult,
//                                  final RedirectAttributes redirectAttributes) {
//        ChangePassValidator changePassValidator = new ChangePassValidator();
//        changePassValidator.validate(changePass, bindingResult);
//        if (bindingResult.hasErrors()) {
//            redirectAttributes.addFlashAttribute("message", "Please fill out the form above to change your password!");
//            return "redirect:/interviewer/changePassword.html";
//        } else {
//            if (changePass.getNewPass().equals(changePass.getReNewPass())) {
//                Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//                String name = auth.getName();
//                Interviewer interviewer = this.interviewerService.findInterviewerbyUserName(name);
//
//                interviewer.setPassword(changePass.getNewPass());
//
//                interviewerService.edit(interviewer);
//                redirectAttributes.addFlashAttribute("message", "Change Password Successful");
//                return "redirect:/interviewer/changePassword.html";
//            }
//            redirectAttributes.addFlashAttribute("message", "Your password and confirmation password do not match!!!");
//            return "redirect:/interviewer/changePassword.html";
//        }
//
//    }

}
