package com.kadous.gestiondealer.utils;

public interface Constants {

  String APP_ROOT = "transaction/v1";

  String COMMANDE_FOURNISSEUR_ENDPOInteger = APP_ROOT + "/commandesfournisseurs";
  String CREATE_COMMANDE_FOURNISSEUR_ENDPOInteger = COMMANDE_FOURNISSEUR_ENDPOInteger + "/create";
  String FIND_COMMANDE_FOURNISSEUR_BY_ID_ENDPOInteger = COMMANDE_FOURNISSEUR_ENDPOInteger + "/{idCommandeFournisseur}";
  String FIND_COMMANDE_FOURNISSEUR_BY_CODE_ENDPOInteger = COMMANDE_FOURNISSEUR_ENDPOInteger + "/filter/{codeCommandeFournisseur}";
  String FIND_ALL_COMMANDE_FOURNISSEUR_ENDPOInteger = COMMANDE_FOURNISSEUR_ENDPOInteger + "/all";
  String DELETE_COMMANDE_FOURNISSEUR_ENDPOInteger = COMMANDE_FOURNISSEUR_ENDPOInteger + "/delete/{idCommandeFournisseur}";

  String ENTREPRISE_ENDPOInteger = APP_ROOT + "/entreprises";

  String FOURNISSEUR_ENDPOInteger = APP_ROOT + "/fournisseurs";

  String UTILISATEUR_ENDPOInteger = APP_ROOT + "/utilisateurs";

  String VENTES_ENDPOInteger = APP_ROOT + "/ventes";
}
