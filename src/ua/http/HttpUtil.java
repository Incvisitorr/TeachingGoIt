package ua.http;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpUtil {
    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final Gson GSON = new Gson();

    public static User sendGet(URI uri) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
        final HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        final User user = GSON.fromJson(response.body(), User.class);
        return user;
    }

    public static String sendGetComments(URI uri) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
        final HttpResponse<String> responseComments = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return responseComments.body();
    }

    public static String sendGetByName(URI uri) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
        final HttpResponse<String> responseByName = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return responseByName.body();
    }

    public static String sendGetById(URI uri) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
        final HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        //final User user = GSON.fromJson(response.body(), User.class);
        return response.body();

    }

    public static User getRequest(URI uri) throws Exception {
        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(uri)
                .build();
        HttpResponse<String> getResponse = CLIENT.send(getRequest, HttpResponse.BodyHandlers.ofString());
        return GSON.fromJson(getResponse.body(), User.class);
    }

    public static User sendPost(URI uri, User user) throws IOException, InterruptedException {
        String requestBody = GSON.toJson(user);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .header("Content-type", "application/json;charset=UTF-8")
                .build();
        final HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Status of POST: " + response.statusCode());
        System.out.println("Body of POST : " + response.body());
        return GSON.fromJson(response.body(), User.class);
    }

    public static void sendGetForPrint(URI uri) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/users/"))
                .GET()
                .build();
        final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    public static void deleteUser(URI uri, User user) throws IOException, InterruptedException {
        String requestBody = GSON.toJson(user);
        HttpRequest deleteRequest = HttpRequest.newBuilder()
                .uri(uri)
                .header("Content-type", "application/json;charset=UTF-8")
                .method("DELETE", HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        final HttpResponse<String> deleteResponse = CLIENT.send(deleteRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("Body of DELETE: " + deleteResponse.body());
        System.out.println("Status of DELETE: " + deleteResponse.statusCode());
    }

    public static void updateUserById(URI uri, User user) throws IOException, InterruptedException {
        String requestBody = GSON.toJson(user);
        HttpRequest updateUserById = HttpRequest.newBuilder()
                .uri(uri)
                .header("Content-type", "application/json;charset=UTF-8")
                .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        final HttpResponse<String> deleteResponse = CLIENT.send(updateUserById, HttpResponse.BodyHandlers.ofString());
        System.out.println("Body of PUT: " + deleteResponse.body());
        System.out.println("Status of PUT: " + deleteResponse.statusCode());
    }

    //        .var1
//        HttpClient client= HttpClient.newHttpClient();
//        HttpRequest request=HttpRequest.newBuilder()
//                .uri(URI.create("https://jsonplaceholder.typicode.com/users/"))
//                .GET()
//                .build();
//        final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        //System.out.println("Header "+response.headers());
//        System.out.println(response.body());
//        //System.out.println("Body "+response.statusCode());

//        //.var 2
//        String url="https://jsonplaceholder.typicode.com/users";
//        String respons = Jsoup
//                .connect(url)
//                .ignoreContentType(true)
//                .get()
//                .body()
//                .text();
//        System.out.println(respons);
}
