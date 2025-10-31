package com.restapi.gestion_bons.contracts;

import java.util.List;

import com.restapi.gestion_bons.dto.stocklot.BaseStockLotDTO;
import com.restapi.gestion_bons.dto.stocklot.ResponseStockLotDTO;
import com.restapi.gestion_bons.entitie.CommandeFournisseur;

public interface StockLotContract {
    ResponseStockLotDTO save(BaseStockLotDTO dto, CommandeFournisseur cf);

    ResponseStockLotDTO update(Long id, BaseStockLotDTO dto, CommandeFournisseur cf);

    ResponseStockLotDTO findById(Long id);

    List<ResponseStockLotDTO> findAll();

    void delete(Long id);
}
