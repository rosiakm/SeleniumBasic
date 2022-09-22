package helpers;

import com.github.javafaker.Faker;

public class DataFaker {
    Faker faker = new Faker();

    public String setFirstName(){
        return faker.name().firstName();
    }
    public String setLastName(){
        return faker.name().lastName();
    }
    public String setEmail(){
        return faker.internet().emailAddress();
    }
    public String setPassword(){
        return faker.internet().password();
    }
}
