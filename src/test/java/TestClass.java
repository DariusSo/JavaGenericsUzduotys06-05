import org.example.Maistas;
import org.example.ProduktuKatalogas;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Date;

public class TestClass {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    ProduktuKatalogas pr;
    static LocalDate date;
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



    @BeforeEach
    public void start(){
        pr = new ProduktuKatalogas();
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @BeforeAll
    public static void startUp(){
        date = LocalDate.of(Integer.parseInt("2024"), Integer.parseInt("06"), Integer.parseInt("05"));
    }
    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
