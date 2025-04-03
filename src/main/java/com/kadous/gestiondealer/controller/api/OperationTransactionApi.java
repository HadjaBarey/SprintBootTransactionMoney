package com.kadous.gestiondealer.controller.api;

import static com.kadous.gestiondealer.utils.Constants.APP_ROOT;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kadous.gestiondealer.dto.OperationTransactionDTO;

@RequestMapping(APP_ROOT + "/OperationTranslation")
public interface OperationTransactionApi {
    
    @PostMapping("/create")
    OperationTransactionDTO save(@RequestBody OperationTransactionDTO dto);

    @GetMapping("/{idOperationTransaction}")
    OperationTransactionDTO findById(@PathVariable("idOperationTransaction") Integer id);

    @GetMapping("/all")
    List<OperationTransactionDTO> findAll();

    @DeleteMapping("/delete/{idOperationTransaction}")
    void delete(@PathVariable("idOperationTransaction") Integer id);

    @PutMapping("/update/{idOperationTransaction}")
    OperationTransactionDTO update(@PathVariable("idOperationTransaction") Integer id, @RequestBody OperationTransactionDTO dto);
   
    
    @DeleteMapping("/supprimer")
    void deleteTransaction(
        @RequestParam("telEntreprise")String telEntreprise,
        @RequestParam("dateOp") String dateOp);


     @GetMapping("/listTransaction")
        List<?> listTransaction(
        @RequestParam(value ="entrepriseNumero") String entrepriseNumero,
        @RequestParam(value ="dateopera") String dateopera);


        // @GetMapping("/numeroEntreprise")
        // public ResponseEntity<Map<String, String>> getNumeroTelEntreprise() {
        //     Optional<OperationTranslation> operation = operationTranslationRepository.findFirstByOrderByIdAsc();
        //     if (operation.isPresent()) {
        //         String numero = operation.get().getNumeroTelEntreprise();
        //         return ResponseEntity.ok(Map.of("numeroTelEntreprise", numero));
        //     } else {
        //         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "Aucune entreprise trouvée"));
        //     }
        // }
        

      
}

