package springboot.hibernate.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import springboot.hibernate.entity.Candidate;
import springboot.hibernate.entity.Interview;
import springboot.hibernate.entity.User;
import springboot.hibernate.service.CandidateService;
import springboot.hibernate.service.InterviewService;
import springboot.hibernate.service.UserService;

@EnableWebMvc
@Controller
@RequestMapping(value = "/interview")
public class InterviewController {
    @Autowired
    private InterviewService interviewService;
    @Autowired
    private CandidateService candidateService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        List<Interview> interviews = interviewService.findAll();
        modelMap.addAttribute("interviewList", interviews);

        return "interviewPage";
    }

    @RequestMapping(value = "/add/{id}", method = RequestMethod.GET)
    public String add(@PathVariable(value = "id") int id, ModelMap interviewMap, ModelMap candidateMap) {
        Candidate candidate = candidateService.find(id);
        candidateMap.addAttribute("candidate", candidate);
        Interview interview = new Interview();
        interviewMap.addAttribute("interview", interview);

        return "interviewAdd";
    }

    @RequestMapping(value = "/add/{id}", method = RequestMethod.POST)
    public String add(@PathVariable(value = "id") int id, @ModelAttribute(value = "interview") Interview interview) {
        Candidate candidate = candidateService.find(id);
        interview.setCandidate(candidate);
        interview.setCandidateId(id);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String name = auth.getName();

        User user = userService.findUserByUserName(name);
        interview.setUser(user);
        interview.setUserId(user.getUserId());
        interviewService.create(interview);

        return "redirect:/interview/index";
    }

    @RequestMapping(value = "/candidateView/{id}", method = RequestMethod.GET)
    public String viewByCandidateId(@PathVariable(value = "id") int id, ModelMap modelMap) {
        List<Interview> interviewList = interviewService.findByCandidateId(id);
        modelMap.addAttribute("interviewList", interviewList);

        return "interviewHistory";
    }

    @RequestMapping(value = "/userView/{id}", method = RequestMethod.GET)
    public String viewByUserId(@PathVariable(value = "id") int id, ModelMap modelMap) {
        List<Interview> interviewList = interviewService.findByUserId(id);
        modelMap.addAttribute("interviewList", interviewList);

        return "interviewHistory";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable(value = "id") int id, RedirectAttributes redirectAttributes) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetail = (UserDetails) auth.getPrincipal();
        User user = userService.findUserByUserName(userDetail.getUsername());
        Interview interview = interviewService.find(id);
        if ((user.getUserId() != interview.getUserId())
                && user.getRole().getRoleName().contains("ROLE_USER")) {
            redirectAttributes.addFlashAttribute("message",
                    "Your role is INTERVIEWER - You can only DELETE your candidate!!!");
            return "interviewPage";
        } else
            interviewService.remove(id);
        redirectAttributes.addFlashAttribute("message", "The interview has been deleted successful!!!");
        return "redirect:/interview/index";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable(value = "id") int id, ModelMap modelMap, RedirectAttributes redirectAttributes) {
        // If u are user, u can only edit your candidate/interview
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetail = (UserDetails) auth.getPrincipal();
        User user = userService.findUserByUserName(userDetail.getUsername());
        Interview interview = interviewService.find(id);
        if ((user.getUserId() != interview.getUserId()) && user.getRole().getRoleName().contains("ROLE_USER")) {
            redirectAttributes.addFlashAttribute("message", "Your role is User - You can only EDIT your candidate!!!");
            return "redirect:/interview/index";
        } else if (interviewService.find(id) == null) {
            return "redirect:/403.html";
        } else
            modelMap.addAttribute("interview", interview);

        return "interviewEdit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editInterview(@ModelAttribute(value = "interview") Interview interview, RedirectAttributes redirectAttributes) {
        interviewService.edit(interview);
        redirectAttributes.addFlashAttribute("message", "The interview has been edited successful!!!");
		return "redirect:/interview/index";
	}

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

}
