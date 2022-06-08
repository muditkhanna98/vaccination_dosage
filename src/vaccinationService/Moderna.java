package vaccinationService;

import java.util.Date;

public class Moderna extends Vaccination {
    public static int count = 0;

    Moderna(Date vaccinationDate, String cityName) {
        super(vaccinationDate, cityName, "Moderna");
        count++;
    }
}
