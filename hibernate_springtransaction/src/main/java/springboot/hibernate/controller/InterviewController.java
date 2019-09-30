package springboot.hibernate.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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

        User user = userService.findUserByUserName("admin");
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
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        UserDetails userDetail = (UserDetails) auth.getPrincipal();
//        Interviewer interviewer = interviewerService.findInterviewerbyUserName(userDetail.getUsername());
//        Interview interview = interviewService.find(id);
//        if ((interviewer.getInterviewerId() != interview.getInterviewer().getInterviewerId())
//                && interviewer.getRolename().contains("ROLE_INTERVIEWER")) {
//            redirectAttributes.addFlashAttribute("message",
//                    "Your role is INTERVIEWER - You can only DELETE your candidate!!!");
//            return "redirect:/interview.html";
//        } else
            interviewService.remove(id);
        redirectAttributes.addFlashAttribute("message", "The interview has been deleted successful!!!");
        return "redirect:/interview/index";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable(value = "id") int id, ModelMap modelMap, RedirectAttributes redirectAttributes) {
        // If u are interviewer, u can only edit your candidate/interview
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        UserDetails userDetail = (UserDetails) auth.getPrincipal();
//        Interviewer interviewer = interviewerService.findInterviewerbyUserName(userDetail.getUsername());
        Interview interview = interviewService.find(id);
//        if ((interviewer.getInterviewerId() != interview.getInterviewer().getInterviewerId())
//                && interviewer.getRolename().contains("ROLE_INTERVIEWER")) {
//            redirectAttributes.addFlashAttribute("message",
//                    "Your role is INTERVIEWER - You can only EDIT your candidate!!!");
//            return "redirect:/interview.html";
//        } else if (interviewService.find(id) == null) {
//            return "redirect:/403.html";
//        } else
            modelMap.addAttribute("interview", interview);

        return "interviewEdit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editInterview(@ModelAttribute(value = "interview") Interview interview) {
		interviewService.edit(interview);

		return "redirect:/interview/index";
	}

//    @RequestMapping(value = "/edit", method = RequestMethod.POST)
//    public String edit(@ModelAttribute(value = "interview") @Valid Interview interview, BindingResult bindingResult,
//                       RedirectAttributes redirectAttributes) {
//        InterviewValidator interviewValidator = new InterviewValidator();
//        interviewValidator.validate(interview, bindingResult);
//        if (bindingResult.hasErrors() || interview.getCandidate().getName() == null
//                || interview.getCandidate().getUniName() == null || interview.getCandidate().getGpa() < 0
//                || interview.getCandidate().getGpa() > 10 || interview.getCandidate().getSkill() == null
//                || interview.getCandidate().getGraduateYear() == null
//                || interview.getCandidate().getDayOfBirth() == null || interview.getCandidate().getEmail() == null
//                || interview.getCandidate().getPhone() < 0 || interview.getCandidate().getAddress() == null
//                || interview.getCandidate().getDegree() == null) {
//            redirectAttributes.addFlashAttribute("message", "Please fill on the form above to edit your Interview!");
//            return "editInterview";
//        } else {
//            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//            String name = auth.getName();
//            Interviewer i = this.interviewerService.findInterviewerbyUserName(name);
//            interview.setInterviewer(i);
//            interviewService.edit(interview);
//            redirectAttributes.addFlashAttribute("message", "The interview has been edited successful!!!");
//            return "redirect:/interview.html";
//        }
//    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

}
