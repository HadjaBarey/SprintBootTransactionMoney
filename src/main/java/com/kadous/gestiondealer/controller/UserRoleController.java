// package com.kadous.gestiondealer.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.RestController;

// import com.kadous.gestiondealer.controller.api.User_roleApi;
// import com.kadous.gestiondealer.dto.User_roleDto;
// import com.kadous.gestiondealer.model.UserRoleId;
// import com.kadous.gestiondealer.services.UserRoleService;

// @RestController
// public class User_roleController implements User_roleApi{

//     @Autowired
//     private UserRoleService userRoleService;
    
//     public User_roleController(
//         UserRoleService userRoleService
//     ) {
//         this.userRoleService = userRoleService;
//     }
        
//     @Override
//     public User_roleDto save(User_roleDto dto) {
//         return userRoleService.save(dto);
//     }

//     @Override
//     public User_roleDto findById(UserRoleId id) {
//         return userRoleService.findById(id);
//     }

//     @Override
//     public List<User_roleDto> findAll() {
//         return userRoleService.findAll();
//     }

//     @Override
//     public void delete(UserRoleId id) {
//         userRoleService.deleteById(id);
//     }
// }
