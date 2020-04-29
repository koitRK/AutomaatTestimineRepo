package pckgTwo.servives;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class PublicHolidayService {

    private static final String COUNTRY_CODE = "EE";
    private static final String API_URL = "https://date.nager.at/api/v2/PublicHolidays/";


    public ArrayList<Map<String, String>> getPublicHolidaysByYear(Integer year) {

        Gson gson = new Gson();
        String composedUrl = API_URL +  year + "/" + COUNTRY_CODE;

        try {
            URL url = new URL(composedUrl);
            URLConnection yc = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            String inputLine = in.readLine();
            in.close();

            return gson.fromJson(inputLine, new TypeToken<List<Map<String, String>>>(){}.getType());
        }
        catch (Exception ex) {
            System.out.println("Couldn't get public holidays");
            return null;
        }
    }

    public Integer countHolidaysOnWeekdays(LocalDate startDate, LocalDate endDate){
        ArrayList<Map<String, String>> holidays = getPublicHolidaysByYear(startDate.getYear());
        int holidaysOnWeekdays = 0;

        for (Map<String, String> holiday : holidays){
            LocalDate holidayDate = LocalDate.parse(holiday.get("date"));

            if (!(holidayDate.isBefore(startDate) || holidayDate.isAfter(endDate)) && holidayDate.getDayOfWeek().getValue() < 6){
                holidaysOnWeekdays += 1;
            }
        }
        return holidaysOnWeekdays;
    }

    public Integer countWeekdays(LocalDate startDate, LocalDate endDate){
        endDate = endDate.plusDays(1);
        final DayOfWeek startW = startDate.getDayOfWeek();
        final DayOfWeek endW = endDate.getDayOfWeek();
        final long days = ChronoUnit.DAYS.between(startDate, endDate);
        final long daysWithoutWeekends = days - 2 * ((days + startW.getValue())/7);

        return Math.toIntExact(daysWithoutWeekends + (startW == DayOfWeek.SUNDAY ? 1 : 0) + (endW == DayOfWeek.SUNDAY ? 1 : 0));
    }

    public Integer countWorkdays(LocalDate startDate, LocalDate endDate){
        return countWeekdays(startDate, endDate) - countHolidaysOnWeekdays(startDate, endDate);
    }
}