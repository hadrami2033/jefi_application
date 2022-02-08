package com.example.demo.Web;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Dao.clientRepository;
import com.example.demo.Dao.fournisseurRepository;
import com.example.demo.Entities.Client;
import com.example.demo.Entities.Fournisseur;
import com.example.demo.Entities.jeffiNumber;
import com.example.demo.Metier.fournisseurMetier;
import com.example.demo.Metier.jeffiMetier;

@Controller
public class jeffiController {

	@Autowired
	private jeffiMetier jeffimetier;
	@Autowired
	private fournisseurMetier fournisseurmetier;
	@Autowired
	private clientRepository clientrepository;
	@Autowired
	private fournisseurRepository fournisseurrepository;
	private Date date = new Date(System.currentTimeMillis());
	//private List<Fournisseur> listFournisseurs=fournisseurmetier.Fournisseurs();
	private String fournisseurName="Ali"; 
	
	@RequestMapping(value = "/nouveauNumber", method = RequestMethod.GET)
	public String nouveauJeffiNumber(Model model) {
		List<Fournisseur> listFournisseurs=fournisseurmetier.Fournisseurs();
		model.addAttribute("jeffiNumber",new jeffiNumber());
		model.addAttribute("listFournisseurs", listFournisseurs);
		model.addAttribute("fournisseurName",fournisseurName);
		return "NewJeffiNumber";
	}
	@RequestMapping(value = "/allNumbers", method = RequestMethod.GET)
	public String allJeffiNumbers(Model model) {
		List<jeffiNumber> listNumbers=jeffimetier.jeffiNumbers();
		model.addAttribute("listNumbers", listNumbers);
		return "allJeffiNumbers";
	}
	@RequestMapping(value = "/numbersPayes", method = RequestMethod.GET)
	public String jeffiNumbersPayes(Model model) {
		model.addAttribute("listNumbers", jeffimetier.jeffiNumbersPayes());
		return "allJeffiNumbers";
	}
	@RequestMapping(value = "/numbersNonPayes", method = RequestMethod.GET)
	public String jeffiNumbersNonPayes(Model model) {
		model.addAttribute("listNumbers", jeffimetier.jeffiNumbersNonPaye());
		return "allJeffiNumbers";
	}
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteNumber(long id) {
		jeffiNumber number= jeffimetier.getNumber(id);
		Fournisseur f=number.getFournisseur();
		f.setMontant(f.getMontant()-number.getFourisseurPrix());
		fournisseurmetier.addFournisseur(f);
		jeffimetier.deleteNumber(id);
		return "redirect:/allNumbers";
	}
	@RequestMapping(value = "/paye", method = RequestMethod.GET)
	public String payeNumber(long id) {
		jeffiNumber number= jeffimetier.getNumber(id);
		boolean state=number.isPaye();
		Fournisseur f=number.getFournisseur();
		if(state==true) {
			f.setMontantPaye(f.getMontantPaye()-number.getFourisseurPrix());
		}else {
			f.setMontantPaye(f.getMontantPaye()+number.getFourisseurPrix());
		}
		number.setPaye(!state);
		fournisseurmetier.addFournisseur(f);
		jeffimetier.addJeffiNumber(number);
		return "redirect:/allNumbers";
	}
	@RequestMapping(value = "/allProviders", method = RequestMethod.GET)
	public String allProviders(Model model) {
		List<Fournisseur> listFournisseurs=fournisseurmetier.Fournisseurs();
		model.addAttribute("fournisseurs",listFournisseurs);
		return "allProviders";
	}
	@RequestMapping(value = "/allClients", method = RequestMethod.GET)
	public String allClients(Model model) {
		List<Client> listClients=clientrepository.findAll();
		model.addAttribute("clients",listClients);
		return "allclients";
	}
	@RequestMapping(value = "/nouveauClients", method = RequestMethod.GET)
	public String nouveauClient(Model model) {
		//List<Fournisseur> listFournisseurs=fournisseurmetier.Fournisseurs();
		model.addAttribute("client",new Client());
		//model.addAttribute("listFournisseurs", listFournisseurs);
		return "NewClient";
	}
	@RequestMapping(value = "/nouveauFournisseur", method = RequestMethod.GET)
	public String nouveauFournisseur(Model model) {
		//List<Fournisseur> listFournisseurs=fournisseurmetier.Fournisseurs();
		model.addAttribute("fournisseur",new Fournisseur());
		//model.addAttribute("listFournisseurs", listFournisseurs);
		return "NewProvider";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveNumber(Model model, jeffiNumber jeffinumber,String fournisName) {
		List<Fournisseur> listFournisseurs=fournisseurmetier.Fournisseurs();
		jeffinumber.setDateCreate(date);
		jeffinumber.setPaye(false);
		
		listFournisseurs.forEach((e)-> { if(e.getNom().equals(jeffinumber.getFournisseurName())) {
		 jeffinumber.setFournisseur(e); 
		} 
		});
		Fournisseur f=jeffinumber.getFournisseur();
		f.setMontant(f.getMontant()+jeffinumber.getFourisseurPrix());
		fournisseurmetier.addFournisseur(f);
		jeffimetier.addJeffiNumber(jeffinumber);
		//model.addAttribute("listNumbers",jeffimetier.jeffiNumbers());
		return "redirect:/allNumbers";
	}
	@RequestMapping(value = "/addProvider", method = RequestMethod.POST)
	public String saveProvider(Model model, Fournisseur fournisseur) {
		fournisseurmetier.addFournisseur(fournisseur);
		return "redirect:/allProviders";
	}
	@RequestMapping(value = "/addClient", method = RequestMethod.POST)
	public String saveClient(Model model, Client client) {
		clientrepository.save(client);
		return "redirect:/allClients";
	}
	@RequestMapping(value = "/deleteProvider", method = RequestMethod.GET)
	public String deleteProvider(long id) {
		Fournisseur fournisseur=fournisseurrepository.getOne(id);
		List<jeffiNumber> allNumbers=jeffimetier.jeffiNumbers();
		allNumbers.forEach((e)-> { if(e.getFournisseur().getId() == fournisseur.getId()) {
			 long numbrId=e.getId();
			 jeffimetier.deleteNumber(numbrId);
			} 
		});
		fournisseurmetier.deleteProvider(id);
		return "redirect:/allProviders";
	}
	@RequestMapping(value = "/deleteClient", method = RequestMethod.GET)
	public String deleteClient(long id) {
		clientrepository.deleteById(id);
		return "redirect:/allClients";
	}
	@RequestMapping(value = "/initiale", method = RequestMethod.GET)
	public String Initiale(long id) {
		Client c=clientrepository.getOne(id);
		c.setMontant(0);
		c.setMontantPaye(0);
		clientrepository.save(c);
		return "redirect:/allClients";
	}
	@RequestMapping(value = "/chercheClient", method = RequestMethod.GET)
	public String chercheClient(Model model, @RequestParam(name="nom",defaultValue="")String nom) {
		List<Client> listClients=clientrepository.findClient("%"+nom+"%");
		model.addAttribute("clients",listClients);
		return "allclients";
	}
	@RequestMapping(value = "/chercheProvider", method = RequestMethod.GET)
	public String chercheProvider(Model model, @RequestParam(name="nom",defaultValue="")String nom) {
		List<Fournisseur> listFournisseurs=fournisseurmetier.chercheFournisseur("%"+nom+"%");
		model.addAttribute("fournisseurs",listFournisseurs);
		return "allProviders";
	}
	@RequestMapping(value = "/chercheNumber", method = RequestMethod.GET)
	public String chercheNumber(Model model, @RequestParam(name="mc",defaultValue="")String mc) {
		List<jeffiNumber> listNumber=jeffimetier.chercheNumber("%"+mc+"%");
		model.addAttribute("listNumbers",listNumber);
		return "allJeffiNumbers";
	}
	@RequestMapping(value = "/addMontantForme", method = RequestMethod.GET)
	public String addMontant(Model model,Long id) {
		//List<Fournisseur> listFournisseurs=fournisseurmetier.Fournisseurs();
		model.addAttribute("client",clientrepository.getOne(id));
		//model.addAttribute("listFournisseurs", listFournisseurs);
		return "addMontantForm";
	}
	@RequestMapping(value = "/payeMontantForme", method = RequestMethod.GET)
	public String payeMontant(Model model,Long id) {
		//List<Fournisseur> listFournisseurs=fournisseurmetier.Fournisseurs();
		model.addAttribute("client",clientrepository.getOne(id));
		//model.addAttribute("listFournisseurs", listFournisseurs);
		return "payeMontantForm";
	}
	@RequestMapping(value = "/addClientMontant", method = RequestMethod.POST)
	public String saveMontant(Model model, @RequestParam(name="nouvMont")double nouvMont, @RequestParam(name="clientName")String clientName, @RequestParam(name="clientId")long clientId) {
		Client client=clientrepository.getOne(clientId);
		client.setMontant(client.getMontant()+nouvMont);
		
		clientrepository.save(client);
		return "redirect:/allClients";
	}
	@RequestMapping(value = "/payetMontant", method = RequestMethod.POST)
	public String savePayeMontant(Model model, @RequestParam(name="montDiminue")double montDiminue, @RequestParam(name="clientName")String clientName, @RequestParam(name="clientId")long clientId) {
		
		Client client=clientrepository.getOne(clientId);
		client.setMontantPaye(client.getMontantPaye()+montDiminue);
		clientrepository.save(client);
		return "redirect:/allClients";
	}

} 
