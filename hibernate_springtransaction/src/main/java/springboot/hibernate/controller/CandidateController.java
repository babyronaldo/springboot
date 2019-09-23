package springboot.hibernate.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import springboot.hibernate.entity.Candidate;
import springboot.hibernate.service.CandidateService;

@EnableWebMvc
@Controller
@RequestMapping(value = "/candidate**")
public class CandidateController
{

	@Autowired(required = true)
	private CandidateService candidateService;
	// @Autowired(required = true)
	// private CandidateValidator candidateValidator;

	@RequestMapping(method = RequestMethod.GET)
	// public String index(ModelMap modelMap, int offset)
	// {
	// offset=1;
	// modelMap.addAttribute("listCandidate",
	// candidateService.viewAllCandidate(result, offsetreal);
	// return "listCandidate";
	// }
	public String index(HttpServletRequest request, HttpSession session, ModelMap modelMap)
	{
		// offset is page number
		String offset = (String) request.getParameter("offSet");
		// result is number of record displayed on each page
		int result = 10;
		// size is the total number of record present in DB
		int size;
		List<Integer> pageList = new ArrayList<Integer>();
		List<Candidate> candidate;
		/*
		 * in the beginning we set page number zero
		 */ if (offset != null)
		{
			int offsetreal = Integer.parseInt(offset);
			offsetreal = offsetreal * 10;
			candidate = candidateService.viewAllCandidate(result, offsetreal);

		} else
		{
			candidate = candidateService.viewAllCandidate(result, 0);
			size = candidateService.getSize();
			/*
			 * if total record are divisible by 10 then we set page list size
			 * one less than total size to avoid empty last page i.e if total
			 * record are 1220 then page list size will be 121 because here we
			 * are taking page list size from 0-121 which is 122 pages
			 */
			if ((size % result) == 0)
			{
				session.setAttribute("size", (size / 10) - 1);
			} else
			{
				session.setAttribute("size", size / 10);
			}
		}
		System.out.println(session.getAttribute("size").toString());
		/*
		 * when user click on any page number then this part will be executed.
		 * else part will be executed on load i.e first time on page
		 */
		if (offset != null)
		{
			int listsize = Integer.parseInt(session.getAttribute("size").toString());
			if (Integer.parseInt(offset) < 6)
			{
				if (listsize >= 10)
				{
					for (int i = 1; i <= 9; i++)
					{
						pageList.add(i);
					}
				} else
				{
					for (int i = 1; i <= listsize; i++)
					{
						pageList.add(i);
					}
				}

			} else
			{
				if (listsize >= 10 && Integer.parseInt(offset) - 5 > 0)
				{
					List<Integer> temp = new ArrayList<Integer>();
					for (int i = Integer.parseInt(offset); i > Integer.parseInt(offset) - 5; i--)
					{
						temp.add(i);
					}
					for (int i = temp.size() - 1; i >= 0; i--)
					{
						pageList.add(temp.get(i));
					}
				}
				if (listsize >= 10 && Integer.parseInt(offset) + 5 < listsize)
				{
					for (int i = Integer.parseInt(offset) + 1; i < Integer.parseInt(offset) + 5; i++)
					{
						pageList.add(i);
					}
				} else if (listsize >= 10)
				{
					for (int i = Integer.parseInt(offset) + 1; i < listsize; i++)
					{
						pageList.add(i);
					}
				}
			}
		} else
		{
			int listsize = Integer.parseInt(session.getAttribute("size").toString());
			if (listsize >= 10)
			{
				for (int i = 1; i <= 10; i++)
				{
					pageList.add(i);
				}
			} else
			{
				for (int i = 1; i <= listsize; i++)
				{
					pageList.add(i);
				}
			}
		}

		session.setAttribute("pageList", pageList);
		session.setAttribute("listCandidate", candidate);
		return "listCandidate";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(ModelMap modelMap)
	{
		modelMap.addAttribute("candidate", new Candidate());

		return "addCandidate";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@ModelAttribute(value = "candidate") @Valid Candidate candidate, BindingResult bindingResult)
	{
//		CandidateValidator candidateValidator = new CandidateValidator();
//		candidateValidator.validate(candidate, bindingResult);

		if (bindingResult.hasErrors())
		{
			return "addCandidate";
		} else
		{
			// Authentication auth =
			// SecurityContextHolder.getContext().getAuthentication();
			// String name = auth.getName();
			// Manager m = this.managerService.findManagerbyUserName(name);
			// candidate.setManager(m);

			candidateService.create(candidate);
			return "redirect:/candidate.html";
		}
	}

	// // add interview from exist candidate
	// @RequestMapping(value = "/addinterview/{id}", method = RequestMethod.GET)
	// public String addinterview(@PathVariable(value = "id") int id, ModelMap
	// modelMap)
	// {
	// Candidate candidate = candidateService.find(id);
	// // modelMap.addAttribute("candidate", candidate);
	// Interview interview = new Interview();
	// interview.setCandidate(candidate);
	// modelMap.addAttribute("interview", interview);
	//
	// return "addInterviewFromCandidate";
	// }
	//
	// @RequestMapping(value = "/addinterview/{id}", method =
	// RequestMethod.POST)
	// public String addinterview(@ModelAttribute(value = "interview") @Valid
	// Interview interview,
	// RedirectAttributes redirectAttributes)
	// {
	// Authentication auth =
	// SecurityContextHolder.getContext().getAuthentication();
	// String name = auth.getName();
	// Interviewer i = this.interviewerService.findInterviewerbyUserName(name);
	// interview.setInterviewer(i);
	// // interview.setCandidate(candidate);
	//
	// interviewService.create(interview);
	// redirectAttributes.addFlashAttribute("message", "Add an Interview form
	// exist Candidate successful!!!");
	// return "redirect:/interview.html";
	// }

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable(value = "id") int id)
	{
		// Interview interview = new Interview();
		if (candidateService.find(id) == null)
		{
			return "redirect:/403.html";
		} else
		{
			candidateService.remove(candidateService.find(id));
		}

		return "redirect:/candidate.html";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable(value = "id") int id, ModelMap modelMap)
	{
		modelMap.addAttribute("candidate", candidateService.find(id));

		if (candidateService.find(id) == null)
		{
			return "redirect:/403.html";
		} else
		{
			candidateService.edit(candidateService.find(id));
		}

		// modelMap.addAttribute("listManager", managerService.findAll());
		return "editCandidate";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(@ModelAttribute(value = "candidate") @Valid Candidate candidate, BindingResult bindingResult,
			final RedirectAttributes redirectAttributes)
	{
//		CandidateValidator candidateValidator = new CandidateValidator();
//		candidateValidator.validate(candidate, bindingResult);
		if (bindingResult.hasErrors())
		{
			return "editCandidate";
		} else
		{
			// Authentication auth =
			// SecurityContextHolder.getContext().getAuthentication();
			// String name = auth.getName();
			// Manager m = this.managerService.findManagerbyUserName(name);
			// candidate.setManager(m);
			candidateService.edit(candidate);
			redirectAttributes.addFlashAttribute("message", "Save Applicant Successful");
			return "redirect:/candidate.html";
		}
	}

	// @RequestMapping(value = "*", method = RequestMethod.GET)
	// public String welcome(ModelMap modelMap)
	// {
	// Authentication auth =
	// SecurityContextHolder.getContext().getAuthentication();
	// UserDetails userDetail = (UserDetails) auth.getPrincipal();
	// modelMap.addAttribute("interviewer",
	// interviewerService.findInterviewerbyUserName(userDetail.getUsername()));
	// return "/candidate**";
	// }

	@InitBinder
	protected void initBinder(WebDataBinder binder)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
}
