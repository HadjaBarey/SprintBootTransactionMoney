// package com.kadous.gestiondealer.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.RestController;

// import com.kadous.gestiondealer.controller.api.User_permissionApi;
// import com.kadous.gestiondealer.dto.User_permissionDto;
// import com.kadous.gestiondealer.model.UserPermissionId;
// import com.kadous.gestiondealer.services.UserPermissionService;

// @RestController
// public class User_permissionController implements User_permissionApi{

//     @Autowired
//     private UserPermissionService userPermissionService;
    
//     public User_permissionController(
//         UserPermissionService userPermissionService
//     ) {
//         this.userPermissionService = userPermissionService;
//     }
        
//     @Override
//     public User_permissionDto save(User_permissionDto dto) {
//         return userPermissionService.save(dto);
//     }

//     @Override
//     public User_permissionDto findById(UserPermissionId id) {
//         return userPermissionService.findById(id);
//     }

//     @Override
//     public List<User_permissionDto> findAll() {
//         return userPermissionService.findAll();
//     }

//     @Override
//     public void delete(UserPermissionId id) {
//         userPermissionService.deleteById(id);
//     }

// }
