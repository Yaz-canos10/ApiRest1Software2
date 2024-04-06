package com.apiRest.ApiRest.controlador;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.apiRest.ApiRest.modelo.Vehiculo;
import com.fasterxml.jackson.databind.ObjectMapper;



@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

   private List<Vehiculo>vehiculos;

   public  VehiculoController(){
   
         try {
        
                ObjectMapper objectMapper =new ObjectMapper();
                Vehiculo []  vehiculosArray=objectMapper.readValue(new ClassPathResource("vehiculos.json").getFile(),Vehiculo[].class);
                vehiculos = new ArrayList<>(Arrays.asList(vehiculosArray));    
    
        } catch(IOException e) {
            e.printStackTrace();
            vehiculos = new ArrayList<>();

        }

    }

    @GetMapping

    public List<Vehiculo> getAllVehiculos(){
        return vehiculos;
    }

    @GetMapping("/{Marca}")

  

    public Vehiculo  getVehiculoByVehiculo(@PathVariable String marca){
           return vehiculos.stream()
                          .filter(vehiculo-> vehiculo.getMarca().equals(marca)).findFirst().orElse(null);                     
}

@PostMapping

public Vehiculo creatVehiculo(@RequestBody  Vehiculo vehiculo){
    vehiculos.add(vehiculo);
    return vehiculo;

}

@PutMapping
public Vehiculo updateVehic (@PathVariable String marca, @RequestBody Vehiculo updatedVehiculo ){
    Vehiculo vehiculo = getVehiculoByVehiculo(marca);
    if(vehiculo!=null){ 
        vehiculo.setModelo(updatedVehiculo.getModelo());
        vehiculo.setLanzamiento(updatedVehiculo.getLanzamiento());
        vehiculo.setColor(updatedVehiculo.getColor());
        return  vehiculo; 

    }   
    return null;
}
 @DeleteMapping
 public void deleteVehiculo(@PathVariable String marca){
    vehiculos.removeIf(vehiculo -> vehiculo.getMarca().equals(marca));
 }
 
}


