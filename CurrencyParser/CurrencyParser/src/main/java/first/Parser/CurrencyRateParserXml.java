package first.Parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import first.Model.CurrencyRate;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class CurrencyRateParserXml {

    public void getCurrencyRates() {
        try {
            // Получение данных с сайта ЦБ РФ
            URL url = new URL("https://www.cbr.ru/scripts/XML_daily.asp");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Чтение данных из потока и преобразование в строку
                String response = new BufferedReader(new InputStreamReader(connection.getInputStream(),"Windows-1251"))
                        .lines().collect(Collectors.joining("\n"));

                // Парсинг данных
                CurrencyRateParser parser = (xml) -> {
                    var rates = new ArrayList<CurrencyRate>();

                    var dbf = DocumentBuilderFactory.newInstance();
                    dbf.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
                    dbf.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
                    try {
                        dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
                        var db = dbf.newDocumentBuilder();

                        try (var reader = new StringReader(xml)) {
                            Document doc = db.parse(new InputSource(reader));
                            doc.getDocumentElement().normalize();

                            NodeList list = doc.getElementsByTagName("Valute");

                            for (var valuteIdx = 0; valuteIdx < list.getLength(); valuteIdx++) {
                                var node = list.item(valuteIdx);
                                if (node.getNodeType() == Node.ELEMENT_NODE) {
                                    var element = (Element) node;
                                    var charCode = element.getElementsByTagName("CharCode").item(0).getTextContent();

                                    // Добавляем только курсы EUR и USD
                                    if ("EUR".equals(charCode) || "USD".equals(charCode)) {
                                        var rate = CurrencyRate.builder()
                                                .numCode(element.getElementsByTagName("NumCode").item(0).getTextContent())
                                                .charCode(element.getElementsByTagName("CharCode").item(0).getTextContent())
                                                .nominal(element.getElementsByTagName("Nominal").item(0).getTextContent())
                                                .name(element.getElementsByTagName("Name").item(0).getTextContent())
                                                .value(element.getElementsByTagName("Value").item(0).getTextContent())
                                                .build();


                                        rates.add(rate);
                                    }
                                }
                            }
                        }
                    } catch (Exception ex) {
                        log.error("xml parsing error, xml:{}", xml, ex);
                        throw new CurrencyRateParsingException(ex);
                    }
                    return rates;
                };
                List<CurrencyRate> rates = parser.parse(response);

                // Преобразование результатов в JSON
                String jsonResult = new ObjectMapper().writeValueAsString(rates);
                try (FileWriter fileWriter = new FileWriter("currency_rates.json", StandardCharsets.UTF_8)) {
                    fileWriter.write(jsonResult);
                }
            }
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
}