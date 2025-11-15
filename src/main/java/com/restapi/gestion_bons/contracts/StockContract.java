package com.restapi.gestion_bons.contracts;

import com.restapi.gestion_bons.dto.mouvementstock.MouvementStockResponseDTO;
import com.restapi.gestion_bons.dto.stock.*;

import java.time.LocalDateTime;
import java.util.List;

public interface StockContract {
    List<StockGlobalDTO> getStockGlobal();

    StockProduitDetailDTO getStockByProduitId(Long produitId);

    List<MouvementStockResponseDTO> getMouvements();

    List<MouvementStockResponseDTO> getMouvementsByProduitId(Long produitId);

    List<StockAlertDTO> getAlertes();

    StockValorisationDTO getValorisation();

    List<MouvementStockResponseDTO> search(
            Long id,
            String typeMouvement,
            LocalDateTime dateMouvement,
            LocalDateTime startDateMouvement,
            LocalDateTime endDateMouvement,
            Integer quantite,
            Integer minQuantite,
            Integer maxQuantite,
            Double prixUnitaireLot,
            Long produitId,
            Long lotId,
            Long bonDeSortieId
    );

}
