package first.Parser;

import first.Model.CurrencyRate;

import java.util.*;

public interface CurrencyRateParser {
    List<CurrencyRate> parse(String xml);
}
