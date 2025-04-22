package com.kadous.gestiondealer.controller.api;

import static com.kadous.gestiondealer.utils.Constants.APP_ROOT;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kadous.gestiondealer.dto.UsersKeyDto;


@RequestMapping(APP_ROOT + "/UsersKey")
public interface UsersKeyApi {
    
    @PostMapping("/create")
    UsersKeyDto save(@RequestBody UsersKeyDto dto);

    @GetMapping("/{numauto}")
    UsersKeyDto findById(@PathVariable("numauto") Integer id);

    @GetMapping("/all")
    List<UsersKeyDto> findAll();

    @DeleteMapping("/delete/{numauto}")
    void delete(@PathVariable("numauto") Integer id);

    @PutMapping("/update/{numauto}")
    UsersKeyDto update(@PathVariable("numauto") Integer id, @RequestBody UsersKeyDto dto);
   
      
      
}

