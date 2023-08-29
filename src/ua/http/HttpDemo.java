package ua.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpDemo {
    public static void main(String[] args) {
//        HttpClient client= HttpClient.newHttpClient();
//        HttpRequest request=HttpRequest.newBuilder()
//                .uri(URI.create("https://jsonplaceholder.typicode.com/users/"))
//                .GET()
//                .build();
//        final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        //System.out.println("Header "+response.headers());
        //System.out.println(response.body());
        //System.out.println("Body "+response.statusCode());
        User user1=new User(111,"Nikolas","1@.net","063-100-888-4","Nikolas.net");
        User.Adress adress=user1.new Adress("Krasnod","185","Kharkov","61176");
        //User.Adress.Geo geo1=new User(111,"Nikolas","1@.net","063-100-888-4","Nikolas.net").new Adress("Krasnod","185","Kharkov","61210").new Geo(1465f,35135f);
        System.out.println(adress);
     }
}
