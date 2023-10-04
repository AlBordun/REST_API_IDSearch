package first.Model;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import first.Parser.CurrencyRateParserXml;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class CurrencyRateCache {
    private Map<String, List<CurrencyRate>> cache = new ConcurrentHashMap<>();
    private Map<String, LocalDateTime> expirationTimes = new ConcurrentHashMap<>();

    public List<CurrencyRate> getCurrencyRates() {
        String cacheKey = "currency_rates"; // Уникальный ключ для кеширования

        if (cache.containsKey(cacheKey) && expirationTimes.containsKey(cacheKey)) {
            LocalDateTime expirationTime = expirationTimes.get(cacheKey);
            if (expirationTime.isAfter(LocalDateTime.now())) {
                // Возвращаем данные из кэша, так как они ещё актуальны
                return cache.get(cacheKey);
            } else {
                // Срок действия данных истек, удаляем их из кэша
                cache.remove(cacheKey);
                expirationTimes.remove(cacheKey);
            }
        }

        // Загрузка данных и сохранение в кэше
        CurrencyRateParserXml parser = new CurrencyRateParserXml();
        parser.getCurrencyRates();

        // Получение данных из файла JSON
        List<CurrencyRate> rates = readCurrencyRatesFromJson("currency_rates.json");
        if (rates != null && !rates.isEmpty()) {
            // Сохранение данных в кэше и установка срока действия (например, на 1 день)
            cache.put(cacheKey, rates);
            expirationTimes.put(cacheKey, LocalDateTime.now().plusDays(1));
        }

        return rates;
    }

    private List<CurrencyRate> readCurrencyRatesFromJson(String filename) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File jsonFile = new File(filename);

            if (jsonFile.exists()) {
                return objectMapper.readValue(jsonFile, new TypeReference<List<CurrencyRate>>() {});
            } else {
                log.warn("JSON file not found: {}", filename);
            }
        } catch (IOException ex) {
            log.error("Error reading JSON file", ex);
        }

        return null;
    }
}
