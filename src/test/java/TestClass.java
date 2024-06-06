import org.example.Maistas;
import org.example.Produktas;
import org.example.ProduktuKatalogas;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class TestClass {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    ProduktuKatalogas pr;
    static LocalDate date;
    static LocalDate date2;
    @Test
    public void pridetiProduktaPridejusVienaProduktaGaunamTokiPatiSarasoDydi(){
        //Arrange
        Maistas maistas = new Maistas(1, "Pienas", 2.99, date);
        //Act
        pr.pridetiProdukta(maistas);
        //Assert
        Assertions.assertEquals(1, pr.getProductList().size());
    }
    @Test
    public void pridetiProduktaNepridedaISarasoProduktoSuPasikartojanciuId(){
        //Arrange
        Maistas maistas = new Maistas(1, "Pienas", 2.99, date);
        Maistas maistas1 = new Maistas(1, "Pienas1", 2.99, date);
        //Act
        pr.pridetiProdukta(maistas);
        pr.pridetiProdukta(maistas);
        //Assert
        Assertions.assertEquals(1, pr.getProductList().size());
    }
    @Test
    public void pasalintiProduktaPasalinaProduktaIsSaraso(){
        //Arrange
        Maistas maistas = new Maistas(1, "Pienas", 2.99, date);
        pr.pridetiProdukta(maistas);
        //Act
        pr.pasalintiProdukta(1);
        //Assert
        Assertions.assertEquals(0, pr.getProductList().size());
    }
    @Test
    public void pasalintiProduktaNeradusProduktoAtspausdinaKadNerado(){
        //Arrange
        Maistas maistas = new Maistas(1, "Pienas", 2.99, date);
        pr.pridetiProdukta(maistas);
        //Act
        pr.pasalintiProdukta(2);
        //Assert
        Assertions.assertEquals("Toks produktas nerastas\r\n", outputStreamCaptor.toString());
    }
    @Test
    public void gautiProduktusPagalKainaGrazinaProduktusTarp2Ir4Euru(){
        //Arrange
        Maistas maistas = new Maistas(1, "Pienas", 2.99, date);
        Maistas maistas1 = new Maistas(2, "Pienas", 5.99, date);
        pr.pridetiProdukta(maistas);
        pr.pridetiProdukta(maistas1);
        //Act
        List<Produktas> prList = pr.gautiProduktusPagalKaina(2.0, 4.0);
        //Assert
        Assertions.assertEquals(1, prList.size());
    }
    @Test
    public void gautiProduktaPagalPavadinimaGrazinaGeraProdukta(){
        //Arrange
        Maistas maistas = new Maistas(1, "Pienas", 2.99, date);
        Maistas maistas2 = new Maistas(2, "Pienas2", 2.99, date);
        pr.pridetiProdukta(maistas);
        pr.pridetiProdukta(maistas2);
        //Act
        Produktas produktas = pr.gautiProduktaPagalPavadinima("Pienas");
        //Assert
        Assertions.assertEquals(maistas.getPavadinimas(), produktas.getPavadinimas());
    }
    @Test
    public void gautiProduktaPagalPavadinimaGrazinaNull(){
        //Arrange
        Maistas maistas = new Maistas(1, "Pienas", 2.99, date);
        Maistas maistas2 = new Maistas(2, "Pienas2", 2.99, date);
        pr.pridetiProdukta(maistas);
        pr.pridetiProdukta(maistas2);
        //Act
        Produktas produktas = pr.gautiProduktaPagalPavadinima("Pienas3");
        //Assert
        Assertions.assertNull(produktas);
    }
    @Test
    public void rusiuotiPagalPavadinima(){
        //Arrange
        Maistas maistas = new Maistas(1, "Pienas", 2.99, date);
        Maistas maistas2 = new Maistas(2, "Bananas", 2.99, date);
        Maistas maistas3 = new Maistas(3, "Kokosas", 2.99, date);
        pr.pridetiProdukta(maistas);
        pr.pridetiProdukta(maistas2);
        pr.pridetiProdukta(maistas3);
        //Act
        pr.rusiuotiPagalPavadinima();
        //Assert
        Assertions.assertEquals(maistas2, pr.getProductList().getFirst());
        Assertions.assertEquals(maistas, pr.getProductList().getLast());
    }
    @Test
    public void rusiuotiPagalKaina(){
        //Arrange
        Maistas maistas = new Maistas(1, "Pienas", 6.99, date);
        Maistas maistas2 = new Maistas(2, "Bananas", 1.99, date);
        Maistas maistas3 = new Maistas(3, "Kokosas", 4.99, date);
        pr.pridetiProdukta(maistas);
        pr.pridetiProdukta(maistas2);
        pr.pridetiProdukta(maistas3);
        //Act
        pr.rusiuotiPagalKaina();
        //Assert
        Assertions.assertEquals(maistas2, pr.getProductList().getFirst());
        Assertions.assertEquals(maistas, pr.getProductList().getLast());
    }
    @Test
    public void gautiProduktusArtiGaliojimoPabaigos(){
        //Arrange
        Maistas maistas = new Maistas(1, "Pienas", 6.99, date);
        Maistas maistas2 = new Maistas(2, "Bananas", 1.99, date2);
        pr.pridetiProdukta(maistas);
        pr.pridetiProdukta(maistas2);
        //Act
        List<Maistas> temp = maistas.gautiProduktusArtiGaliojimoPabaigos(7, pr.getProductList());
        //Assert
        Assertions.assertEquals(maistas, temp.getFirst());
    }



    @BeforeEach
    public void start(){
        pr = new ProduktuKatalogas();
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @BeforeAll
    public static void startUp(){
        date = LocalDate.of(Integer.parseInt("2024"), Integer.parseInt("06"), Integer.parseInt("08"));
        date2 = LocalDate.of(Integer.parseInt("2024"), Integer.parseInt("06"), Integer.parseInt("30"));
    }
    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
