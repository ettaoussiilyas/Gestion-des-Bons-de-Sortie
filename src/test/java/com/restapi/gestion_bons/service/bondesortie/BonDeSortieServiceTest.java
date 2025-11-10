package com.restapi.gestion_bons.service.bondesortie;

import com.restapi.gestion_bons.dao.*;
import com.restapi.gestion_bons.entitie.*;
import com.restapi.gestion_bons.entitie.enums.LotStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BonDeSortieServiceTest {

    @Mock private LotDAO lotDAO;
    @Mock private MouvementStockDAO mouvementStockDAO;

    @InjectMocks
    private BonDeSortieService bonDeSortieService;

    private BonDeSortieLigne ligne;
    private BonDeSortie bonDeSortie;
    private Produit produit;

    @BeforeEach
    void setUp() {
        produit = Produit.builder()
                .id(1L)
                .nom("Produit A")
                .reference("REF-A")
                .build();

        ligne = BonDeSortieLigne.builder()
                .produit(produit)
                .quantiteDemandee(50)
                .build();

        bonDeSortie = BonDeSortie.builder()
                .id(1L)
                .numeroBon("BS-TEST")
                .build();
    }

    @Test
    void scenario1_SortiePartielleUnLot() {
        // Given
        Lot lot = Lot.builder()
                .id(1L)
                .produit(produit)
                .quantiteRestante(100)
                .quantiteInitiale(100)
                .prixAchatUnitaire(BigDecimal.valueOf(15.0))
                .statut(LotStatus.DISPONIBLE)
                .dateEntree(LocalDateTime.now().minusDays(10))
                .build();

        when(lotDAO.findByProduitIdAndStatutOrderByDateEntreeAsc(1L, LotStatus.DISPONIBLE))
                .thenReturn(List.of(lot));

        // When
        bonDeSortieService.traiterSortieFIFO(ligne, bonDeSortie);

        // Then
        assertEquals(50, lot.getQuantiteRestante());
        verify(mouvementStockDAO).save(any());
        System.out.println("Scénario 1 réussi: Sortie partielle d'un lot");
    }

    @Test
    void scenario2_SortieMultiplesLots() {
        // Given
        Lot lot1 = Lot.builder()
                .id(1L)
                .produit(produit)
                .quantiteRestante(30)
                .quantiteInitiale(50)
                .prixAchatUnitaire(BigDecimal.valueOf(10.0))
                .statut(LotStatus.DISPONIBLE)
                .dateEntree(LocalDateTime.now().minusDays(10))
                .build();

        Lot lot2 = Lot.builder()
                .id(2L)
                .produit(produit)
                .quantiteRestante(40)
                .quantiteInitiale(60)
                .prixAchatUnitaire(BigDecimal.valueOf(12.0))
                .statut(LotStatus.DISPONIBLE)
                .dateEntree(LocalDateTime.now().minusDays(5))
                .build();

        ligne.setQuantiteDemandee(60);

        when(lotDAO.findByProduitIdAndStatutOrderByDateEntreeAsc(1L, LotStatus.DISPONIBLE))
                .thenReturn(List.of(lot1, lot2));

        // When
        bonDeSortieService.traiterSortieFIFO(ligne, bonDeSortie);

        // Then
        assertEquals(0, lot1.getQuantiteRestante());
        assertEquals(10, lot2.getQuantiteRestante());
        verify(mouvementStockDAO, times(2)).save(any());
        System.out.println("Scénario 2 réussi: Sortie multiple lots");
    }

    @Test
    void scenario3_StockInsuffisant() {
        // Given
        Lot lot = Lot.builder()
                .id(1L)
                .produit(produit)
                .quantiteRestante(30)
                .quantiteInitiale(30)
                .prixAchatUnitaire(BigDecimal.valueOf(10.0))
                .statut(LotStatus.DISPONIBLE)
                .dateEntree(LocalDateTime.now().minusDays(10))
                .build();

        ligne.setQuantiteDemandee(50);

        when(lotDAO.findByProduitIdAndStatutOrderByDateEntreeAsc(1L, LotStatus.DISPONIBLE))
                .thenReturn(List.of(lot));

        // When & Then
        IllegalStateException exception = assertThrows(IllegalStateException.class,
                () -> bonDeSortieService.traiterSortieFIFO(ligne, bonDeSortie));

        assertTrue(exception.getMessage().contains("Stock insuffisant"));
        assertTrue(exception.getMessage().contains("Manque: 20"));
        System.out.println("Scénario 3 réussi: Gestion stock insuffisant");
    }

    @Test
    void scenario4_SortieEpuisantStockExact() {
        // Given
        Lot lot1 = Lot.builder()
                .id(1L)
                .produit(produit)
                .quantiteRestante(20)
                .quantiteInitiale(50)
                .prixAchatUnitaire(BigDecimal.valueOf(10.0))
                .statut(LotStatus.DISPONIBLE)
                .dateEntree(LocalDateTime.now().minusDays(10))
                .build();

        Lot lot2 = Lot.builder()
                .id(2L)
                .produit(produit)
                .quantiteRestante(30)
                .quantiteInitiale(30)
                .prixAchatUnitaire(BigDecimal.valueOf(12.0))
                .statut(LotStatus.DISPONIBLE)
                .dateEntree(LocalDateTime.now().minusDays(5))
                .build();

        ligne.setQuantiteDemandee(50);

        when(lotDAO.findByProduitIdAndStatutOrderByDateEntreeAsc(1L, LotStatus.DISPONIBLE))
                .thenReturn(List.of(lot1, lot2));

        // When
        bonDeSortieService.traiterSortieFIFO(ligne, bonDeSortie);

        // Then
        assertEquals(0, lot1.getQuantiteRestante());
        assertEquals(0, lot2.getQuantiteRestante());
        assertEquals(LotStatus.EPUISE, lot1.getStatut());
        assertEquals(LotStatus.EPUISE, lot2.getStatut());
        verify(mouvementStockDAO, times(2)).save(any());
        System.out.println("Scénario 4 réussi: Sortie épuisant stock exact");
    }
}
    //mvn test -Dtest=BonDeSortieServiceTest
