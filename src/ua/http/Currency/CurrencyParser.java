package ua.http.Currency;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class CurrencyParser {
    public static void main(String[] args) throws IOException {
        String url = "https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=5";
        //Get Json
        String respons = Jsoup
                .connect(url)
                .ignoreContentType(true)
                .get()
                .body()
                .text();
        System.out.println(respons);


        //Параметризированный лист
        Type typeToken = TypeToken
                .getParameterized(List.class, CurrencyItem.class)
                .getType();
        //Конвертируем JSON в Java-обьекты которые в листе
        Gson gson = new Gson();
        List<CurrencyItem> currencyItems = gson.fromJson(respons, typeToken);
        System.out.println(currencyItems);

        //Найти доллар к гривне
        Float uahUsd = currencyItems.stream()
                .filter(item -> item.getCcy() == CurrencyItem.CCY.USD)
                .filter(item -> item.getBase_ccy() == CurrencyItem.CCY.UAH)
                .map(item -> item.getBuy())
                .findFirst()
                .orElseThrow();
        System.out.println("Курс доллара: " + uahUsd);
    }
}
