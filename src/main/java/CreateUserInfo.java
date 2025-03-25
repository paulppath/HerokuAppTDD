import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import java.util.ArrayList;
import com.github.javafaker.Faker;
import java.io.IOException;

public class CreateUserInfo
{
	public static void main(String[] args)
	{
		String path = "/Users/paul/Documents/Java Src/JavaSRC/practice/codingTest/users.txt";
		List<String> newUser = newUser();

		try(BufferedWriter bWriter = new BufferedWriter(new FileWriter(path)))
		{
			for(String info : newUser)
			{
				bWriter.write(info);
				bWriter.newLine();
			}
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}

	public static List<String> newUser()
	{
		List<String> user = new ArrayList<>();

		Faker faker = new Faker();
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		user.add(firstName);
		user.add(lastName);
		user.add(firstName + lastName + "@gmail.com");
		user.add(faker.phoneNumber().phoneNumber());
		user.add(faker.address().streetAddress());
		user.add(faker.address().city());
		user.add(faker.address().state());
		user.add(faker.address().zipCode());

		return user;
	}
}