package banky.example.banky.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import banky.example.banky.Entity.Compte;
import banky.example.banky.Entity.Operation;
import banky.example.banky.Service.BankService;

@Controller
public class BankController {
    @Autowired
    BankService bankService;                                                                                          
    
    

    @RequestMapping("/")
    public String index() {
        return"index";
    }
    

    @GetMapping("/consulterCompte")
    public String consulter(Model model,String codeCompte,
    @RequestParam(name = "page",defaultValue="0")int page,
    @RequestParam(name = "size",defaultValue="5")int size)
    {
        model.addAttribute("codeCompte",codeCompte);
        try{
           Compte cp =bankService.consulterCompte(codeCompte);
           model.addAttribute("compte",cp); 
           Page<Operation> pageOperation=bankService.listOperation(codeCompte, page, size);
           model.addAttribute("listOperation",pageOperation.getContent());
           int[] pages=new int[pageOperation.getTotalPages()];
           model.addAttribute("pages",pages);
            
        }catch(Exception e){
            model.addAttribute("exception",e);
        }
        return"index";
    }

    @RequestMapping(value = "/saveOperation",method=RequestMethod.POST)
    public String saveOperation(Model model,String typeOperation,String codeCompte,Double montant,String codeCompte2){
        try{
        if(typeOperation.equals("VERS")){
            bankService.verser(codeCompte,montant);
        }
        else if( typeOperation.equals("RETR")){
            bankService.retirer(codeCompte,montant);
        }
        if(typeOperation.equals("VIR")){
            bankService.virement(codeCompte, codeCompte2, montant);
        }
        }catch(Exception e){
            model.addAttribute("error",e);
            return"redirect:/consulterCompte?codeCompte="+codeCompte+"&error="+e.getMessage();

        }
        return"redirect:/consulterCompte?codeCompte="+codeCompte;
    }
}
