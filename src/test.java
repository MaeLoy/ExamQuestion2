import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

    class test{

        @Test
        void GetVat_WithValidData_ReturnsCorrectValue() {
            ProductCalculations p = new ProductCalculations();
            assertEquals(0.15, actualResult);
        }


}
