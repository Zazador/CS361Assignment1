import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SecureSystem {
	public static void main(String[] args) throws FileNotFoundException {
		File file1 = new File(args[0]);
		Scanner scan = new Scanner(file1);
		System.out.println("Reading from file: " + file1);
		System.out.println();

		SecurityLevel low = SecurityLevel.LOW;
		SecurityLevel high = SecurityLevel.HIGH;

		while (scan.hasNextLine()) {
			String curLine = scan.nextLine();
			InstructionObject instrobj = new InstructionObject(curLine);
		}

		System.out.println("K DONE!");
		scan.close();
	}

}