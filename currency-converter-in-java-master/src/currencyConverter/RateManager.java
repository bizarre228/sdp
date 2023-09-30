package currencyConverter;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.HashMap;

public class RateManager {
    private static RateManager instance;
    private HashMap<String, Double> exchangeRates;

    private RateManager() {
        // Initialize exchange rates here
        exchangeRates = new HashMap<>();
        exchangeRates.put("US Dollar-Euro", 0.93);
        exchangeRates.put("US Dollar-British Pound", 0.66);
        exchangeRates.put("US Dollar-Swiss Franc", 1.01);
        exchangeRates.put("US Dollar-Chinese Yuan Renminbi", 6.36);
        exchangeRates.put("US Dollar-Japanese Yen", 123.54);
        exchangeRates.put("Euro-British Pound", 0.71);
        exchangeRates.put("Euro-US Dollar", 1.073);
        exchangeRates.put("Euro-Swiss Franc", 1.08);
        exchangeRates.put("Euro-Chinese Yuan Renminbi", 6.83);
        exchangeRates.put("Euro-Japanese Yen", 132.57);
        exchangeRates.put("British Pound-Swiss Franc", 1.52);
        exchangeRates.put("British Pound-US Dollar", 1.51);
        exchangeRates.put("British Pound-Euro", 1.41);
        exchangeRates.put("British Pound-Chinese Yuan Renminbi", 9.60);
        exchangeRates.put("British Pound-Japanese Yen", 186.41);
        exchangeRates.put("Swiss Franc-Chinese Yuan Renminbi", 6.33);
        exchangeRates.put("Swiss Franc-US Dollar", 0.99);
        exchangeRates.put("Swiss Franc-Japanese Yen", 122.84);
        exchangeRates.put("Swiss Franc-Euro", 0.93);
        exchangeRates.put("Swiss Franc-British Pound", 0.66);
        exchangeRates.put("Chinese Yuan Renminbi-Japanese Yen", 19.41);
        exchangeRates.put("Chinese Yuan Renminbi-US Dollar", 0.16);
        exchangeRates.put("Chinese Yuan Renminbi-Euro", 0.15);
        exchangeRates.put("Chinese Yuan Renminbi-British Pound", 0.16);
        exchangeRates.put("Chinese Yuan Renminbi-Swiss Franc", 19.41);
        exchangeRates.put("Japanese Yen-US Dollar", 0.008);
        exchangeRates.put("Japanese Yen-Euro", 0.007);
        exchangeRates.put("Japanese Yen-British Pound", 0.005);
        exchangeRates.put("Japanese Yen-Swiss Franc", 0.008);
        exchangeRates.put("Japanese Yen-Chinese Yuan Renminbi", 0.051);
    }

    public static RateManager getInstance() {
        if (instance == null) {
            synchronized (RateManager.class) {
                if (instance == null) {
                    instance = new RateManager();
                }
            }
        }
        return instance;
    }

    public Double getExchangeRate(String sourceCurrency, String targetCurrency) {

        String key = sourceCurrency + "-" +targetCurrency;
        if(exchangeRates.get(key) == null){
           String newKey = targetCurrency + "-" + sourceCurrency;
           return exchangeRates.get(newKey);
        }else if(exchangeRates.get(key) == null && targetCurrency.equals(sourceCurrency)){
            return 1.0;
        }else{
            return exchangeRates.get(key);
        }
    }
}
