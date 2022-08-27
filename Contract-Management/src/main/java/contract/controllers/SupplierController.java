package contract.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import contract.models.Amenities;
import contract.models.Contract;
import contract.models.Proposal;
import contract.models.Supplier;
import contract.services.AmenityService;
import contract.services.ContractService;
import contract.services.ProposalService;
import contract.services.RequirementService;
import contract.services.SupplierService;

@Controller
public class SupplierController {
	
	@Autowired SupplierService ssrv;
	@Autowired RequirementService rsrv;
	@Autowired ProposalService psrv;
	@Autowired ContractService csrv;
	@Autowired AmenityService asrv;
	@Autowired HttpSession session;
	
	@GetMapping("/supplier")
	public String supplierpage(Model model) {
		Supplier sup=new Supplier();
		sup.setSupid(ssrv.generateId());
		model.addAttribute("supplier", sup);
		return "supplier";
	}
	
	@PostMapping("/supplier")
	public String saveSupplier(@Valid Supplier sup,BindingResult br,Model model,RedirectAttributes redirAttrs) {
		boolean valid=true;
		if(br.hasErrors()) {
			valid=false;
		}		
		if(!sup.getCpwd().equals(sup.getPwd())) {
			br.rejectValue("cpwd","error.cpwd","Password not match");
			valid=false;
		}
		
		if(!valid) {
			model.addAttribute("user", sup);
			return "supplier";
		}
		else {
			ssrv.saveSupplier(sup);
			redirAttrs.addFlashAttribute("msg", "Supplier registerd successfully");
			return "redirect:/supplier";
		}
		
	}
	
	@GetMapping("/suplogin")
	public String supplierlogin() {
		return "suplogin";
	}
	
	@GetMapping("/sendprop")
	public String sendproposal(Model model) {
		model.addAttribute("propid", psrv.generateId());
		model.addAttribute("reqs", rsrv.allreq());
		return "createproposal";
	}
	
	@PostMapping("/sendprop")
	public String saveProposal(Proposal p,RedirectAttributes ra) {
		psrv.saveProp(p);
		ra.addFlashAttribute("msg", "Proposal send");
		return "redirect:/sendprop";
	}
	
	@PostMapping("/suplogin")
	public String validate(String userid,String pwd,RedirectAttributes ra) {
		Supplier sup=ssrv.Validate(userid, pwd);
		if(sup==null) {
			ra.addFlashAttribute("error", "Invalid username or password");
			return "redirect:/suplogin";
		}else {
			session.setAttribute("userid", userid);
			session.setAttribute("uname", sup.getName());
			session.setAttribute("role", "Supplier");
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/myviewprops")
	public String viewproposals(Model model) {
		String supid=session.getAttribute("userid").toString();
		model.addAttribute("list", psrv.suppropsals(supid));
		return "viewproposals";
	}
	
	@GetMapping("/resendprop")
	public String resendproposal(Model model,int propid) {
		model.addAttribute("p", psrv.findProposal(propid));
		return "resubmitprop";
	}
	
	@PostMapping("/resendprop")
	public String resaveProposal(Proposal p,RedirectAttributes ra) {
		psrv.saveProp(p);
		ra.addFlashAttribute("msg", "Proposal submitted");
		return "redirect:/myviewprops";
	}
	
	@GetMapping("/addcontract")
	public String addcontract(Model model) {
		model.addAttribute("id", csrv.generateId());
		return "createcontract";
	}
	
	@PostMapping("/addcontract")
	public String savecontract(Contract c,RedirectAttributes ra) {
		csrv.saveContract(c);
		ra.addFlashAttribute("msg", "Contract created");
		return "redirect:/mycontracts";
	}
	
	@GetMapping("/cdetails")
	public String contractdetails(Model model,int id) {
		model.addAttribute("c", csrv.findContract(id));
		model.addAttribute("alist", asrv.contractamenities(id));
		return "contractdetails";
	}
	
	@PostMapping("/addamenity")
	public String addamenity(Amenities am) {
		asrv.saveAmenity(am);
		return "redirect:/cdetails?id="+am.getCid();
	}
	
	@GetMapping("/mycontracts")
	public String mycontracts(Model model) {
		String supid=session.getAttribute("userid").toString();
		model.addAttribute("list", csrv.supcontracts(supid));
		return "contracts";
	}
	
	@GetMapping("/managedelivery")
	public String managedelivery(Model model) {
		model.addAttribute("manage", true);
		String supid=session.getAttribute("userid").toString();
		model.addAttribute("list", csrv.supcontracts(supid));
		return "managedelivery";
	}
	
	@GetMapping("/updatedelivery")
	public String updatedevliery(int id,Model model) {
		model.addAttribute("c", csrv.findContract(id));
		return "updatedelivery";
	}
	
	@PostMapping("/updatedelivery")
	public String updatedevliery(int cid,String delivery,Model model) {
		csrv.updateDelivery(cid, delivery);
		return "redirect:/managedelivery";
	}
	
	@GetMapping("/editdetails")
	public String editcontract(Model model,int id) {
		model.addAttribute("c", csrv.findContract(id));
		model.addAttribute("alist", asrv.contractamenities(id));
		return "updatecontract";
	}
	
	@PostMapping("/editdetails")
	public String updatedetails(Contract c,Model model) {
		csrv.updateContract(c);
		return "redirect:/mycontracts";
	}
}
