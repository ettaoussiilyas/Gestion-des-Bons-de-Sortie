package com.restapi.gestion_bons.service.stocklot;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.restapi.gestion_bons.contracts.StockLotContract;
import com.restapi.gestion_bons.dao.StockLotDAO;
import com.restapi.gestion_bons.dto.stocklot.ResponseStockLotDTO;
import com.restapi.gestion_bons.dto.stocklot.BaseStockLotDTO;
import com.restapi.gestion_bons.entitie.CommandeFournisseur;
import com.restapi.gestion_bons.entitie.StockLot;
import com.restapi.gestion_bons.mapper.StockLotMapper;

@Service
@Primary
@RequiredArgsConstructor
public class StockLotService implements StockLotContract {
    private final StockLotDAO stockLotDAO;
    private final StockLotMapper stockLotMapper;

    @Override
    public ResponseStockLotDTO save(BaseStockLotDTO dto, CommandeFournisseur cf) {
        if (dto == null) {
            throw new IllegalArgumentException("BaseStockLotDTO must not be null");
        }
        if (dto.getProductId() == null) {
            throw new IllegalArgumentException("productId must be provided when creating a stock lot");
        }

        StockLot sl = stockLotMapper.toEntity(dto);
        StockLot saved = stockLotDAO.save(sl);

        ResponseStockLotDTO response = stockLotMapper.toResponseDto(saved);
        // populate commande ref if present
        if (cf != null) {
            response.setCommandeFournisseur(cf);
        }
        return response;
    }

    @Override
    public ResponseStockLotDTO update(Long id, BaseStockLotDTO dto, CommandeFournisseur cf) {
        if (id == null)
            throw new IllegalArgumentException("id must not be null");

        stockLotDAO.findById(id)
                .orElseThrow(() -> new NoSuchElementException("StockLot not found with id: " + id));

        StockLot toUpdate = stockLotMapper.toEntity(dto);
        toUpdate.setId(id);
        StockLot updated = stockLotDAO.save(toUpdate);

        ResponseStockLotDTO response = stockLotMapper.toResponseDto(updated);
        if (cf != null) {
            response.setCommandeFournisseur(cf);
        }
        return response;
    }

    @Override
    public ResponseStockLotDTO findById(Long id) {
        StockLot found = stockLotDAO.findById(id)
                .orElseThrow(() -> new NoSuchElementException("StockLot not found with id: " + id));
        ResponseStockLotDTO response = stockLotMapper.toResponseDto(found);
        return response;
    }

    @Override
    public List<ResponseStockLotDTO> findAll() {
        List<StockLot> all = stockLotDAO.findAll();
        return all.stream().map(stockLotMapper::toResponseDto).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (!stockLotDAO.existsById(id)) {
            throw new NoSuchElementException("StockLot not found with id: " + id);
        }
        stockLotDAO.deleteById(id);
    }
}
