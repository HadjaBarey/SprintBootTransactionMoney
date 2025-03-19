package com.kadous.gestiondealer.controller.api;

import static com.kadous.gestiondealer.utils.Constants.APP_ROOT;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//import com.kadous.gestiondealer.dto.OperationDto;
import com.kadous.gestiondealer.dto.UsersDto;

@RequestMapping(APP_ROOT + "/users")
@CrossOrigin(origins = "http://localhost:3000")  // Permet l'accès à l'application Nuxt.js
public interface UsersApi {

    @PostMapping("/create")
    UsersDto save(@RequestBody UsersDto dto);

    @GetMapping("/{idUsers}")
    UsersDto findById(@PathVariable("idUsers") Integer id);

    @GetMapping("/all")
    List<UsersDto> findAll();

    @DeleteMapping("/delete/{idUsers}")
    void delete(@PathVariable("idUsers") Integer id);

    @PutMapping("/update/{idUsers}")
    UsersDto update(@PathVariable("idUsers") Integer id, @RequestBody UsersDto dto);

    @GetMapping("/utilisateurInfo")
    List<?> utilisateurInfo(@RequestParam("rechercheEmail") String rechercheEmail); 
}
