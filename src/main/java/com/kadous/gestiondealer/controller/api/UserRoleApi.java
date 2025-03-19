// package com.kadous.gestiondealer.controller.api;

// import static com.kadous.gestiondealer.utils.Constants.APP_ROOT;

// import java.util.List;

// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;

// import com.kadous.gestiondealer.dto.User_roleDto;
// import com.kadous.gestiondealer.model.UserRoleId;

// import io.swagger.annotations.Api;

// @Api("userRole")
// public interface User_roleApi {

//     @PostMapping(value = APP_ROOT + "/userRole/create")
//     User_roleDto save(@RequestBody User_roleDto dto);

//     @GetMapping(value = APP_ROOT + "/userRole/{idUserRole}")
//     User_roleDto findById(@PathVariable("idUserRole") UserRoleId id);

//     @GetMapping(value = APP_ROOT + "/userRole/all")
//     List<User_roleDto> findAll();

//     @DeleteMapping(value = APP_ROOT + "/userRole/delete/{idUserRole}")
//     void delete(@PathVariable("idUserRole") UserRoleId id);
// }
