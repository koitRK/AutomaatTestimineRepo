package pckgTwo.servives;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.google.gson.JsonSyntaxException;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
//import sun.rmi.rmic.Names;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;



import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PublicHolidayServiceTest {

    PublicHolidayService service = new PublicHolidayService("http://localhost");


    @Test
    public void processes_api_response() throws IOException {
        WireMockServer wireMockServer = new WireMockServer(options().port(80));
        wireMockServer.start();
        WireMock.configureFor("localhost", wireMockServer.port());

        System.out.println("still here");
        stubFor(any(anyUrl())
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/xml")
                        .withBody("[{\"date\":\"2020-01-01\",\"localName\":\"uusaasta\",\"name\":\"New Year's Day\"," +
                                "\"countryCode\":\"EE\",\"fixed\":true,\"global\":true,\"counties\":null,\"launchYear\":null,\"type\":\"Public\"}]")));

        List<Map<String, String>> result = service.getPublicHolidaysByYear(2020);

        verify(1, anyRequestedFor(anyUrl()));

        assertEquals(1, result.size());
        assertEquals(LocalDate.parse("2020-01-01"), LocalDate.parse(result.get(0).get("date")));

        verify(getRequestedFor(urlEqualTo("/2020/EE")));

        wireMockServer.stop();
    }


    @Test
    public void throws_json_syntax_exception_on_invalid_api_response() {
        WireMockServer wireMockServer = new WireMockServer(options().port(80));
        wireMockServer.start();
        WireMock.configureFor("localhost", wireMockServer.port());
        stubFor(any(anyUrl())
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/xml")
                        .withBody("<response>Some content</response>")));

        Assertions.assertThrows(JsonSyntaxException.class, () -> {
            service.getPublicHolidaysByYear(2020);
        });

        wireMockServer.stop();
    }

    @Test
    public void throws_exception_on_empty_json_array_response() {
        WireMockServer wireMockServer = new WireMockServer(options().port(80));
        wireMockServer.start();
        WireMock.configureFor("localhost", wireMockServer.port());
        stubFor(any(anyUrl())
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/xml")
                        .withBody("[]")));

        Assertions.assertThrows(IllegalStateException.class, () -> {
            service.getPublicHolidaysByYear(2020);
        });
        wireMockServer.stop();
    }

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