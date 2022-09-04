package com.UdeA.Ciclo3.Service;

import com.UdeA.Ciclo3.Modelos.Empresa;
import com.UdeA.Ciclo3.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpresaService {
    @Autowired      //Esto es para que se auto-conecte a la clase EmpresaRepository.
    EmpresaRepository empresaRepository;    // Creamos un objeto tipo EmpresaRepository para poder usar los métodos de dicha clase.

    // Creamos un método para ver todas las empresas que tenemos registradas.
    public List<Empresa> getAllEmpresas(){
        List<Empresa> empresaList = new ArrayList<>();  //Creamos la lista que las va a contener.

        //Llamamos al método de JpaRepository para buscar todo. Hasta ahí me devuelve un objeto iterable.
        //con ".forEach" pedimos que recorra cada empresa dentro de este objeto y la agrege a la lista que se acabó de crear.
        empresaRepository.findAll().forEach(empresa -> empresaList.add(empresa));
        return empresaList;
    }

    // Método para traer un objeto de tipo empresa mediante su Id.
    public Empresa getEmpresaById(Integer id) {
        return empresaRepository.findById(id).get();
    }

    // Método para guardar o actualizar objetos de tipo Empresa.
    public boolean saveOrUpdateEmpresa(Empresa empresa){
        Empresa emp = empresaRepository.save(empresa);
        //Si la empresa existe, devuelve un true, si no un false.
        if (empresaRepository.findById(emp.getId()) != null){
            return true;
        }
        return false;
    }

    //Método para eliminar empresas registradas teniendo el id
    public boolean deleteEmpresa (Integer id){
        empresaRepository.deleteById(id);
        //Para saber si se borró, vamos a buscar la empresa usando el método getEmpresaById
        if (getEmpresaById(id) != null){
            return false;
        }
        return true;
    }

}

