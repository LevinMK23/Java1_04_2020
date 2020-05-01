package HomeWork8;

import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class DataStat {

    private static ArrayList<Row> data = new ArrayList<>();
    private static boolean initialized = false;


    private static void initialize() throws IOException{

        //if (initialized){return;}

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpUriRequest request = new HttpGet("http://disease.sh/v2/countries");
        HttpResponse response = httpClient.execute(request);

        // Get the response
        BufferedReader rd = new BufferedReader
                (new InputStreamReader(response.getEntity().getContent()));

        String line = rd.readLine();
        //System.out.println(line);
        String[] arrLine;
        if(line != null){ arrLine = line.split("updated"); }
        else { arrLine = new String[0];};

        String country = "";
        String cases = "";
        String continent = "";

        for (String c : arrLine) {
            country = Parser(c,"country");
            cases = Parser(c,"cases");
            continent = Parser(c,"continent");

            if (!country.equals("")) {
                data.add(new Row(continent,country,Integer.parseInt(cases)));
                //System.out.println(continent);
            };
        }

        initialized = true;

    }

    private static String Parser(String c,String str) {

        //int index = c.indexOf("country");
        int index = c.indexOf(str);
        int numberOfCharactersToAdd;
        String result = "";
        char cEnd;

        if (str.equals("country")) {
            numberOfCharactersToAdd = 10;
            cEnd = '"';
        }
        else if ((str.equals("cases"))) {
            numberOfCharactersToAdd = 7;
            cEnd = ',';
        }
        else{
            numberOfCharactersToAdd = 12;
            cEnd = '"';
        };

        if (index  > 0) {
            index += numberOfCharactersToAdd;
            ;
            while(true){
                if (c.charAt(index) == cEnd ){
                    break;
                }else{
                    result = result + c.charAt(index);
                }
                index++;
            }

        }
        return result;

    }

    public static ArrayList<Row> getDataByFilter(String continent) throws IOException {

            if (!initialized) {
                initialize();
            }

            if(continent == "--") return data;
            else return data.stream().filter(row -> row.continent.equals(continent)).collect(Collectors.toCollection(ArrayList::new));
    }

}
