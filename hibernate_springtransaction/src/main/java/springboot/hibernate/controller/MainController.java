package springboot.hibernate.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import springboot.hibernate.dao.BankAccountDAO;
import springboot.hibernate.entity.Candidate;
import springboot.hibernate.exception.BankTransactionException;
import springboot.hibernate.form.SendMoneyForm;
import springboot.hibernate.service.CandidateService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "/main")
public class MainController {
    @Autowired
    private CandidateService candidateService;
    @Autowired
    private CandidateController candidateController;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {

        return "redirect:/main/login.html";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout, ModelMap mm) {
        if (error != null) {
            mm.addAttribute("msg", "Invalid username and password! Do you have account?");
        }
        if (logout != null) {
            mm.addAttribute("msg", "You've been logged out successfully.");
        }
        return "login";
    }

}