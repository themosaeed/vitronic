import org.testng.annotations.Test;

public class MakeReservationTest extends BaseTest{

    String departureCity = "Cairo (CAI)";
    String DestinationCity = "Sharjah (SHJ)";
    String DepTargetYear = "2024";
    String DepTargetMonth = "August";
    String DepTargetDay = "4";
    String returnTargetYear = "2024";
    String returnTargetMonth = "August";
    String returnTargetDay = "30";
    String numberOfAdults = "2";
    String numberOfInfants = "2";


    @Test
    public void reservationFirstStep(){
        new HomePage(driver).
                selectFlight(departureCity,
                        DestinationCity,
                        DepTargetMonth,
                        DepTargetYear,
                        DepTargetDay,
                        returnTargetMonth,
                        returnTargetYear,
                        returnTargetDay,
                        numberOfAdults,
                        numberOfInfants)
                .selectFaresAndPrintFinalValue();

    }
}
