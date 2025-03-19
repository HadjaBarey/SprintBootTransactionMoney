// package com.kadous.gestiondealer.controller.api;

// import static com.kadous.gestiondealer.utils.Constants.APP_ROOT;

// import java.util.List;

// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;

// import com.kadous.gestiondealer.dto.User_permissionDto;
// import com.kadous.gestiondealer.model.UserPermissionId;

// import io.swagger.annotations.Api;

// @Api("user_permission")
// public interface User_permissionApi {

//     @PostMapping(value = APP_ROOT + "/userPermission/create")
//     User_permissionDto save(@RequestBody User_permissionDto dto);

//     @GetMapping(value = APP_ROOT + "/userPermission/{idUserPermission}")
//     User_permissionDto findById(@PathVariable("idUserPermission") UserPermissionId id);

//     @GetMapping(value = APP_ROOT + "/userPermission/all")
//     List<User_permissionDto> findAll();

//     @DeleteMapping(value = APP_ROOT + "/userPermission/delete/{idUserPermission}")
//     void delete(@PathVariable("idUserPermission") UserPermissionId id);
// }
