package com.kadous.gestiondealer.dto;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.kadous.gestiondealer.model.OperationTransaction;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class OperationTransactionDTO {

    private Integer codeoperation;
    private Integer idoperation;
    private String dateoperation;
    private String montant;
    private String numeroTelephone;
    private String infoClient;
    private Integer typeOperation;
    private String operateur;
    private Integer supprimer;
    private Integer iddette;
    private boolean optionCreance;
    private String scanMessage;  
    private String numeroIndependant;
    private String idTrans;  
    private Instant created_at;
    private Instant updated_at;


    public static OperationTransactionDTO fromEntity(OperationTransaction operationTransaction) {
        if (operationTransaction == null) {
          return null;
        }
    
        return new OperationTransactionDTO(
            operationTransaction.getCodeoperation(),
            operationTransaction.getIdoperation(),
            operationTransaction.getDateoperation(),
            operationTransaction.getMontant(),
            operationTransaction.getNumeroTelephone(),
            operationTransaction.getInfoClient(),
            operationTransaction.getTypeoperation(),
            operationTransaction.getOperateur(),
            operationTransaction.getSupprimer(),             
            operationTransaction.getIddette(),
            operationTransaction.getOptioncreance(),
            operationTransaction.getScanmessage(),          
            operationTransaction.getNumeroindependant(),
            operationTransaction.getIdtrans(),
            operationTransaction.getCreated_at(),
            operationTransaction.getUpdated_at()
            
          //.build();
        );
    }


    public OperationTransaction toEntity(OperationTransactionDTO dto) {
        if (dto == null) {
          return null;
        }
    
        OperationTransaction operationTransaction = new OperationTransaction();
        operationTransaction.setIdoperation(this.getIdoperation());
        operationTransaction.setDateoperation(this.getDateoperation()); 
        operationTransaction.setMontant(this.getMontant()); 
        operationTransaction.setNumeroTelephone(this.getNumeroTelephone());
        operationTransaction.setInfoClient(this.getInfoClient());
        operationTransaction.setTypeoperation(this.getTypeOperation()); 
        operationTransaction.setOperateur(this.getOperateur()); 
        operationTransaction.setSupprimer(this.getSupprimer());  
        operationTransaction.setIddette(this.getIddette());
        operationTransaction.setOptioncreance(this.isOptionCreance());
        operationTransaction.setScanmessage(this.getScanMessage());
        operationTransaction.setNumeroindependant(this.getNumeroIndependant()); 
        operationTransaction.setIdtrans(this.getIdTrans()); 
        operationTransaction.setCreated_at(this.getCreated_at());
        operationTransaction.setUpdated_at(this.getUpdated_at());

        
        return operationTransaction;
    }
    


    
}
