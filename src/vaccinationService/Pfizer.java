package vaccinationService;

import java.util.Date;

public class Pfizer extends Vaccination {
    public static int count = 0;

    Pfizer(Date vaccinationDate, String cityName) {
        super(vaccinationDate, cityName, "Pfizer");
        count++;
    }
}
