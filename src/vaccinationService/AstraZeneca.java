package vaccinationService;

import java.util.Date;

public class AstraZeneca extends Vaccination {
    public static int count = 0;

    AstraZeneca(Date vaccinationDate, String cityName) {
        super(vaccinationDate, cityName, "AstraZeneca");
        count++;
    }
}
