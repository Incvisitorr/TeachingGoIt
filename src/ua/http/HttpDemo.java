package ua.http;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;

class HttpDemo1 {
    private static final String URL = "https://jsonplaceholder.typicode.com/users";
    private static final String LIST_ALL_RES_URL = "https://jsonplaceholder.typicode.com/users";
    private static final String GET_USER_BY_ID_URL = "https://jsonplaceholder.typicode.com/users/5";
    private static final String GET_USER_BY_NAME_URL = "https://jsonplaceholder.typicode.com/users?username=Delphine";
    private static final String GET_USER_TODOS_URL = "https://jsonplaceholder.typicode.com/users/1/todos";
    private static final String GET_USER_COMMENTS_URL = "https://jsonplaceholder.typicode.com/posts/1/comments";


    public static void main(String[] args) throws Exception {
        Geo geoUser1=new Geo(-35.00f,54.00f);
        Address adUser1=new Address(geoUser1,"Krasnodarska","Suite 612","Kharkov","315-485");
        Company companyUser1=new Company("Niko-kola","NiceBro","ljknsg-dgsd-dg");
        User user1=new User(888,"Nikolas","8work8@gmail.com",adUser1,"+380631008884","Niko.com",companyUser1);


        //Завдання 1. отримання інформації про всіх користувачів
        System.out.println("Get all of Users:");
        HttpUtil.sendGetForPrint(URI.create(LIST_ALL_RES_URL));

        //Завдання 1. отримання інформації про користувача за id
        User userById = HttpUtil.sendGet(URI.create(GET_USER_BY_ID_URL));
        System.out.println("Get User by ID:\n"+userById);
        System.out.println();

        //Завдання 1. створення нового об'єкта
        System.out.println("Create new Object:");
        final User createUser1 = HttpUtil.sendPost(URI.create(URL), user1);
        System.out.println();

        //Завдання 1. видалення об'єкта
        System.out.println("DELETE Object:");
        HttpUtil.deleteUser(URI.create(GET_USER_BY_ID_URL),userById);
        System.out.println();

        //Завдання 1. оновлення інформації
        System.out.println("PUT Object:");
        HttpUtil.updateUserById(URI.create(GET_USER_BY_ID_URL),userById);
        System.out.println();

        //Завдання 1. отримання інформації про користувача за name----------------------------------------------
        System.out.println("Get User by Name");
        System.out.println(HttpUtil.sendGetByName(URI.create(GET_USER_BY_NAME_URL)));
        System.out.println();
        //Завдання 3. всі відкриті задачі для користувача з ідентифікатором
        System.out.println("Get todos of User:");
        System.out.println("Get User todos:\n"+HttpUtil.sendGetById(URI.create(GET_USER_TODOS_URL)));
        System.out.println();
        //Завдання 2
        System.out.println("Get comments of User:");
        String comments=HttpUtil.sendGetComments(URI.create(GET_USER_COMMENTS_URL));
        System.out.println(comments);
        try(FileWriter writer=
                    new FileWriter("D:\\Teaching\\Java\\!!GoIT\\PROGRAMS\\src\\ua\\http\\Resources\\UserComments",false)){
            writer.write(comments);
            writer.flush();
        }

    }
}

