package pckgTwo.servives;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PublicHolidayServiceTest {

    @Test
    public void countWeekdays_normal() {
        LocalDate startDate = LocalDate.of(2020, 1, 1);
        LocalDate endDate = LocalDate.of(2020, 1, 16);

        PublicHolidayService publicHolidayService = new PublicHolidayService();

        int result = publicHolidayService.countWeekdays(startDate, endDate);

        assertEquals(12, result);
    }

    @Test
    public void countWeekdays_weekend_only() {
        LocalDate startDate = LocalDate.of(2020, 1, 4);
        LocalDate endDate = LocalDate.of(2020, 1, 5);

        PublicHolidayService publicHolidayService = new PublicHolidayService();

        int result = publicHolidayService.countWeekdays(startDate, endDate);

        assertEquals(0, result);
    }

    @Test
    public void countWeekdays_equal_date() {
        LocalDate startDate = LocalDate.of(2020, 1, 3);
        LocalDate endDate = LocalDate.of(2020, 1, 3);

        PublicHolidayService publicHolidayService = new PublicHolidayService();

        int result = publicHolidayService.countWeekdays(startDate, endDate);

        assertEquals(1, result);
    }

    @Test
    public void countWeekdays_end_before_start_expect_IllegalArgumentException() {
        LocalDate startDate = LocalDate.of(2020, 1, 5);
        LocalDate endDate = LocalDate.of(2020, 1, 4);

        PublicHolidayService publicHolidayService = new PublicHolidayService();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            publicHolidayService.countWeekdays(startDate, endDate);
        });
    }
}