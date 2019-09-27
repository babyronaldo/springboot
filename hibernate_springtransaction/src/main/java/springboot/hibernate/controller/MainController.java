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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import springboot.hibernate.dao.BankAccountDAO;
import springboot.hibernate.entity.Candidate;
import springboot.hibernate.exception.BankTransactionException;
import springboot.hibernate.form.SendMoneyForm;
import springboot.hibernate.service.CandidateService;

import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    private BankAccountDAO bankAccountDAO;
    @Autowired
    private CandidateService candidateService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String candidateList(Model model) {
        List<Candidate> list = candidateService.findAll();
        model.addAttribute("candidateList", list);

        return "candidatePage";
    }

    @RequestMapping(value = "/candidateDetail/{id}", method = RequestMethod.GET)
    public String candidateDetail(@PathVariable(value = "id") int id, ModelMap modelMap) {
        modelMap.addAttribute("candidate", candidateService.find(id));

        return "candidateDetail";
    }

    @RequestMapping(value = "/candidateDetail", method = RequestMethod.POST)
    public String edit(@ModelAttribute(value = "candidate") Candidate candidate) {
//		CandidateValidator candidateValidator = new CandidateValidator();
//		candidateValidator.validate(candidate, bindingResult);
//        if (bindingResult.hasErrors()) {
//            return "candidateDetail";
//        } else {
            // Authentication auth =
            // SecurityContextHolder.getContext().getAuthentication();
            // String name = auth.getName();
            // Manager m = this.managerService.findManagerbyUserName(name);
            // candidate.setManager(m);
            candidateService.edit(candidate);
            return "redirect:/";
//        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable(value = "id") int id, final RedirectAttributes redirectAttributes) {
        // Interview interview = new Interview();
        if (candidateService.find(id) == null) {
            return "redirect:/403.html";
        } else {
            candidateService.delete(id);
            redirectAttributes.addFlashAttribute("message", "Delete Applicant Successful");
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/sendMoney", method = RequestMethod.GET)
    public String viewSendMoneyPage(Model model) {

        SendMoneyForm form = new SendMoneyForm(1L, 2L, 700d);

        model.addAttribute("sendMoneyForm", form);

        return "sendMoneyPage";
    }

    @RequestMapping(value = "/sendMoney", method = RequestMethod.POST)
    public String processSendMoney(Model model, SendMoneyForm sendMoneyForm) {

        System.out.println("Send Money::" + sendMoneyForm.getAmount());

        try {
            bankAccountDAO.sendMoney(sendMoneyForm.getFromAccountId(), //
                    sendMoneyForm.getToAccountId(), //
                    sendMoneyForm.getAmount());
        } catch (BankTransactionException e) {
            model.addAttribute("errorMessage", "Error: " + e.getMessage());
            return "/sendMoneyPage";
        }
        return "redirect:/";
    }
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }
}