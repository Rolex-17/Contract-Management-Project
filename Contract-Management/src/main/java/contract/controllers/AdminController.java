package contract.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import contract.models.AdminUser;
import contract.models.Requirement;
import contract.services.AdminuserService;
import contract.services.ContractService;
import contract.services.ProposalService;
import contract.services.RequirementService;

@Controller
public class AdminController {
	
	@Autowired AdminuserService asrv;
	@Autowired RequirementService rsrv;
	@Autowired ProposalService psrv;
	@Autowired HttpSession session;
	@Autowired ContractService csrv;
	
	@GetMapping("/adminlogin")
	public String contractadminlogin() {
		return "adminlogin";
	}
	
	@PostMapping("/adminlogin")
	public String validate(String userid,String pwd,RedirectAttributes ra) {
		AdminUser ad=asrv.Validate(userid, pwd);
		if(ad==null) {
			ra.addFlashAttribute("error", "Invalid username or password");
			return "redirect:/adminlogin";
		}else {
			session.setAttribute("role", "Admin");
			session.setAttribute("uname", ad.getName());
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/contracts")
	public String allcontracts(Model model) {
		model.addAttribute("list", csrv.allcontracts());
		return "contracts";
	}
	
	@GetMapping("/dashboard")
	public String dashboard() {
		return "adminhome";
	}
	
	@GetMapping("/createreq")
	public String createrequirement(Model model) {
		model.addAttribute("reqid", rsrv.generateId());
		return "createreq";
	}
	
	
	@PostMapping("/createreq")
	public String saverequirement(Requirement req,RedirectAttributes ra) {
		rsrv.saveReq(req);
		ra.addFlashAttribute("msg", "Requirement created");
		return "redirect:/createreq";
	}
	
	@GetMapping("/viewreq")
	public String viewrequirement(Model model) {
		model.addAttribute("list", rsrv.allreq());
		return "viewreq";
	}
	
	@GetMapping("/viewprops")
	public String viewproposals(Model model) {
		model.addAttribute("list", psrv.allpropsals());
		return "viewproposals";
	}
	
	@GetMapping("/vwdelivery")
	public String viewdelivery(Model model) {
		model.addAttribute("list", csrv.allcontracts());
		return "managedelivery";
	}
	
	@GetMapping("/propaction")
	public String propaction(Model model,int propid,String status,RedirectAttributes ra) {
		psrv.updateStatus(propid, status);
		ra.addFlashAttribute("msg", "Status updated");
		return "redirect:/viewprops";
	}
	
	@GetMapping("/caction")
	public String contractaction(Model model,int id,String status,RedirectAttributes ra) {
		csrv.updateStatus(id, status);
		ra.addFlashAttribute("msg", "Status updated");
		return "redirect:/contracts";
	}
	
	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/";
	}
}
