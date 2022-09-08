package com.UdeA.Ciclo3.controller;

import com.UdeA.Ciclo3.Modelos.Empresa;
import com.UdeA.Ciclo3.Service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

//Controller y RestController se ocupan de llevar y traer datos hacia y desde un servidor.
//@RestController        //Es una forma de avisarle al sistema que éste es el controlador.
@Controller
public class Controlador {
    @Autowired  //Para mantener enlazado...
    EmpresaService empresaService;  //Permite usar todos los métodos de la clase EmpresaService.

    @GetMapping ({"/","/VerEmpresas"})
    public String viewEmpresas(Model model){    //Model es un método que podemos usar para establecer características.
        List<Empresa> listaEmpresas=empresaService.getAllEmpresas();
        //El modelo va a ser "emprList" y se va a alimentar de listaEmpresas
        model.addAttribute("emprList", listaEmpresas);
        return "verEmpresas";   //Llamamos al archivo HTML en templates con exactamente el mismo nombre.

    }

    @GetMapping("/AgregarEmpresa")
    public String nuevaEmpresa(Model model){
        Empresa emp= new Empresa();
        model.addAttribute("empr", emp);
        return "agregarEmpresa";
    }

    @PostMapping("/GuardarEmpresa") //Se usa Post porque vamos a crear un nuevo elemento, llevar info y setearla.
    public String guardarEmpresa(Empresa empr, RedirectAttributes redirectAttributes){
        if(empresaService.saveOrUpdateEmpresa(empr)==true){
            return "redirect:/VerEmpresas";
        }
        return "redirect:/AgregarEmpresa";
    }

}
