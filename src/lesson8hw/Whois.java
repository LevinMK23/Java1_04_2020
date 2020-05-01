package lesson8hw;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Whois {
    private static String domain;
    private StringBuffer response = new StringBuffer();
    private String errorMessage = "Введены некорректные данные!";

    public Whois(String domain) {
        this.domain = domain;
    }

    private boolean checkInput() {
        // Check correct input data
        String regexIP = "([0-9]{1,3}[\\.]){3}[0-9]{1,3}";
        String regexDomain = "(?:[a-z0-9](?:[a-z0-9-]{0,61}[a-z0-9])?\\.)+[a-z0-9][a-z0-9-]{0,61}[a-z0-9]";
        return (domain.matches(regexIP) | domain.matches(regexDomain));
    }

    private void request() throws IOException {
        // Send get request
        URL url = new URL("http://ip-api.com/json/" + domain);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        // Check response code
        int responseCode = connection.getResponseCode();
        if (responseCode != 200) {
            System.out.println("Internet connection error!");
        } else {
            // Read answer
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String answer;
            while ((answer = reader.readLine()) != null) {
                response.append(answer);
            }
            reader.close();
        }
    }

    private String parseAnswer() throws ParseException {
        // Parse JSON
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(String.valueOf(response));
        if (json.get("status").equals("fail")) {
            String answer = "Данный домен или IP-адрес не существует!";
            return answer;
        } else {
            String answer = "\nIP address: " + json.get("query") +
                    "\nStatus: " + json.get("status") +
                    "\nCountry: " + json.get("country") +
                    "\nRegion name: " + json.get("regionName") +
                    "\nCity: " + json.get("city") +
                    "\nTimezone: " + json.get("timezone") +
                    "\nISP: " + json.get("isp") +
                    "\nOrg: " + json.get("org") +
                    "\nAs: " + json.get("as");
            return answer;
        }
    }

    public String info() throws IOException, ParseException {
        if (checkInput()) {
            request();
            return parseAnswer();
        } else
            return errorMessage;
    }
}
