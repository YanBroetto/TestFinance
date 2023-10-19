package com.test.finance.repository;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.test.finance.domain.Conversion;
import com.test.finance.domain.Currency;

public class FrankFurterAPI extends GenericAPI {
	
	private static final String URL_BASE = "https://api.frankfurter.app/";
	
	
	private CloseableHttpClient client = HttpClients.createDefault();
	

	@Override
	public List<Currency> getCurrencies() {
            HttpUriRequestBase request = new HttpGet(URL_BASE+"currencies");
            try (CloseableHttpResponse response = client.execute(request)) {
                if (response.getCode() == 200) {
                    String responseBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);

                    List<Currency> currencies = new ArrayList<Currency>();
                    Gson gson = new Gson();
                    Type currencyType = new TypeToken<Map<String, String>>(){}.getType();
                    Map<String, String> currenciesMap = gson.fromJson(responseBody, currencyType);
                    currenciesMap.keySet().forEach(e -> {
                    	currencies.add(new Currency(e, currenciesMap.get(e)));
                    });
                    return currencies;
                } else {
                    System.out.println("Falha na requisição. Código de status: " + response.getCode());
                }
            } catch (ParseException | IOException e) {
                e.printStackTrace();
            }
		return null;
	}

	@Override
	public BigDecimal convert(Conversion conversion) {
		String endpoint = String.format(URL_BASE+"latest?amount=%s&from=%s&to=%s", conversion.getAmount().toString(), conversion.getFrom(), conversion.getTo());
		HttpUriRequestBase request = new HttpGet(endpoint);
        try (CloseableHttpResponse response = client.execute(request)) {
            if (response.getCode() == 200) {
                String responseBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);

                Gson gson = new Gson();
                Type currencyType = new TypeToken<Map<String, ?>>(){}.getType();
                Map<String, ?> conversionMap = gson.fromJson(responseBody, currencyType);
                Map<String, Double> convertedMap = (Map<String, Double>) conversionMap.get("rates");
                return new BigDecimal(convertedMap.get(conversion.getTo()));
            } else {
                System.out.println("Falha na requisição. Código de status: " + response.getCode());
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
	return null;
	}

}
