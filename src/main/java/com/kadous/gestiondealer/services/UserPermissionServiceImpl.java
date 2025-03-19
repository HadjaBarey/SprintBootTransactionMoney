package com.kadous.gestiondealer.services;
// package com.kadous.gestiondealer.services.impl;

// import java.util.List;
// import java.util.stream.Collectors;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.kadous.gestiondealer.dto.User_permissionDto;
// import com.kadous.gestiondealer.exception.EntityNotFoundException;
// import com.kadous.gestiondealer.exception.ErrorCodes;
// import com.kadous.gestiondealer.exception.InvalidEntityException;
// import com.kadous.gestiondealer.model.UserPermissionId;
// import com.kadous.gestiondealer.repository.User_permissionRepository;
// import com.kadous.gestiondealer.services.UserPermissionService;
// import com.kadous.gestiondealer.validator.User_permissionValidator;

// import lombok.extern.slf4j.Slf4j;

// @Service 
// @Slf4j
// public class UserPermissionServiceImpl implements UserPermissionService{

//     @Autowired
//     private User_permissionRepository user_permissionRepository;

//     @Override
//     public User_permissionDto save(User_permissionDto dto) {
//         List<String> errors = User_permissionValidator.validate(dto);
//         if (!errors.isEmpty()) {
//             log.error("Le user_permission n'est pas valide {}", dto);
//             throw new InvalidEntityException("Le user_permission n'est pas valide", ErrorCodes.USER_PERMISSION_NOT_VALID, errors);
//         }
//         return User_permissionDto.fromEntity(
//             user_permissionRepository.save(
//                 User_permissionDto.toEntity(dto)
//             )
            
//         );
//     }

//     @Override
//     public User_permissionDto findById(UserPermissionId id) {
//         if (id == null) {
//             log.error("ID de User_permission est null");
//             return null;
//         }
//         return user_permissionRepository.findById(id).map(User_permissionDto::fromEntity).orElseThrow(() ->
//             new EntityNotFoundException(
//                 "Aucun user_permission avec l'ID = " + id + " n' a été trouvé dans la BDD",
//                 ErrorCodes.USER_PERMISSION_NOT_FOUND)
//         );

//     }

//     @Override
//     public List<User_permissionDto> findAll() {
//         return user_permissionRepository.findAll().stream()
//                 .map(User_permissionDto::fromEntity)
//                 .collect(Collectors.toList());
//     }

//     @Override
//     public void deleteById(UserPermissionId id) {
//         if (id == null) {
//             log.error("L'ID de user_permission est null");
//             return;
//         }
//         user_permissionRepository.deleteById(id);
//     }

// }
