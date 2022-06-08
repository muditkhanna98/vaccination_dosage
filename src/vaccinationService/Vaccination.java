package vaccinationService;

import java.util.Date;

public abstract class Vaccination {
    private Date vaccinationDate;
    private String cityName;
    private String vaccineName;

    Vaccination(Date vaccinationDate, String cityName, String vaccineName) {
        this.vaccinationDate = vaccinationDate;
        this.cityName = cityName;
        this.vaccineName = vaccineName;
    }


    public Date getVaccinationDate() {
        return vaccinationDate;
    }

    public void setVaccinationDate(Date vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String toString() {
        return "The name of the vaccine- " + this.vaccineName + " administered on " + this.vaccinationDate + "\n";
    }
}
