// package com.kadous.gestiondealer.services.impl;

// import java.util.List;
// import java.util.stream.Collectors;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.kadous.gestiondealer.dto.User_roleDto;
// import com.kadous.gestiondealer.exception.EntityNotFoundException;
// import com.kadous.gestiondealer.exception.ErrorCodes;
// import com.kadous.gestiondealer.exception.InvalidEntityException;
// import com.kadous.gestiondealer.model.UserRoleId;
// import com.kadous.gestiondealer.repository.User_roleRepository;
// import com.kadous.gestiondealer.services.UserRoleService;
// import com.kadous.gestiondealer.validator.User_roleValidator;

// import lombok.extern.slf4j.Slf4j;

// @Service
// @Slf4j
// public class UserRoleServiceImpl implements UserRoleService{

//     @Autowired
//     private User_roleRepository user_roleRepository;

//     @Override
//     public User_roleDto save(User_roleDto dto) {
//         List<String> errors = User_roleValidator.validate(dto);
//         if (!errors.isEmpty()) {
//             log.error("Le user_role n'est pas valide {}", dto);
//             throw new InvalidEntityException("Le user_role n'est pas valide", ErrorCodes.USER_ROLE_NOT_VALID, errors);
//         }
//         return User_roleDto.fromEntity(
//             user_roleRepository.save(
//                 User_roleDto.toEntity(dto)
//             )
//         );
//     }

//     @Override
//     public User_roleDto findById(UserRoleId id) {
//         if (id == null) {
//             log.error("ID de user_role est null");
//             return null;
//         }
//         return user_roleRepository.findById(id).map(User_roleDto::fromEntity).orElseThrow(() ->
//             new EntityNotFoundException(
//                 "Aucun user_role avec l'ID = " + id + " n' a été trouvé dans la BDD",
//                 ErrorCodes.ROLES_NOT_FOUND)
//         );
//     }

//     @Override
//     public List<User_roleDto> findAll() {
//         return user_roleRepository.findAll().stream()
//                 .map(User_roleDto::fromEntity)
//                 .collect(Collectors.toList());
//     }

//     @Override
//     public void deleteById(UserRoleId id) {
//         if (id == null) {
//             log.error("L'ID de user_role est null");
//         return;
//         }
//         user_roleRepository.deleteById(id);
//     }
// }

