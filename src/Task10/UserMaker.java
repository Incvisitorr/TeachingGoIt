package Task10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class UserMaker {
    public static void main(String[] args) throws IOException {
        File base = new File("./src/Task10/SourceFiles");
        File source2 = new File(base, "SourceForTask2.txt");
        //File jsonFile = new File(base, "user.json");
        List<User> usersList = new ArrayList<>();

        makeObjectsToJson(source2,usersList);

        Gson gsonBuilder=new GsonBuilder().setPrettyPrinting().create();
        String jsonString= gsonBuilder.toJson(usersList);
        Files.write(Paths.get("D:\\Teaching\\Java\\!!GoIT\\PROGRAMS\\src\\Task10\\SourceFiles\\user.json"),
                jsonString.getBytes(), StandardOpenOption.CREATE);


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

    static class User {
        private String name;
        private int age;

        public User(String[] content) {
            this.name = content[0];
            this.age = Integer.parseInt(content[1]);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
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
