package Task10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class UserMaker {
    public static void main(String[] args) throws IOException {
        File base = new File("./src/Task10/SourceFiles");
        File source2 = new File(base, "SourceForTask2.txt");
        String fileName="D:\\Teaching\\Java\\!!GoIT\\PROGRAMS\\src\\Task10\\SourceFiles\\SourceForTask2.txt";
        String adressOutput = "D:\\Teaching\\Java\\!!GoIT\\PROGRAMS\\src\\Task10\\SourceFiles\\user.json";
        List<User> usersList = new ArrayList<>();

        makeObjectsToJson(source2,usersList);
        parseObjToJson(usersList,adressOutput);
    }
    static void makeObjectsToJson(File source2,List<User> userList){
        BufferedReader reader = null;
        String line = "";
        try {
            reader = new BufferedReader(new FileReader(source2));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            line= reader.readLine();
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                String[] lineContent = line.split(" ");
                try{
                    userList.add(new User(lineContent));
                }catch (NumberFormatException nfe){
                    System.out.println("Couldn't parse entry. Continue.");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static User[] deserialize(String sourceJson){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        User[] userArray = gson.fromJson(sourceJson, User[].class);
        return userArray;
    }
    static void parseObjToJson(List<User> userList, String adress) throws IOException {
        Gson gsonBuilder = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gsonBuilder.toJson(userList);
        FileWriter fw = new FileWriter(adress);
        fw.write(jsonString);
        fw.close();
    }

    static class User {
        @SerializedName("name")
        private String name;
        @SerializedName("age")
        private String age;

        public User() {
        }

        public User(String[] data) {
            this.name = data[0];
            this.age = data[1];
        }
//        public User(String[] content) {
//            this.name = content[0];
//            this.age = Integer.parseInt(content[1]);
//        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
