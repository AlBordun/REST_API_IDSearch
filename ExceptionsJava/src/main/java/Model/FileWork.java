package Model;

import Exceptions.UserDataException;
import Exceptions.ParseException;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class FileWork {
    private Scanner scanner;

    public FileWork(Scanner scanner) {
        this.scanner = scanner;
    }

    public void writeUserData(User user) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write a name of a file: ");
        String fileName = scanner.nextLine();
        FileWriter writer = new FileWriter(fileName, true);
        String userData = String.join(" ",
                user.getLastName(),
                user.getName(),
                user.getSurName(),
                user.getDateOfBirth().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                String.valueOf(user.getPhoneNumber()),
                user.getGender().toString());
        writer.write(userData + "\n");
        writer.close();
        System.out.println("Data was successfully saved: " + fileName);
    }

    public User readUserData() throws UserDataException {
        while (true) {
            System.out.println("Write data in order split by space between type of data: Lastname Firstname Surname " +
                    "Date of birth(dd.mm.yyyy) Phone number Gender(f or m)");
            try {
                String input = scanner.nextLine();
                String[] data = input.split(" ");

                if (data.length != 6) {
                    throw new UserDataException("Wrong amount of data,try again");
                }
                LocalDate dateOfBirth = parseDateOfBirth(data[3]);
                long phoneNumber = parsePhoneNumber(data[4]);
                GenderEnum gender = parseGender(data[5]);

                return new User(data[0], data[1], data[2], dateOfBirth, phoneNumber, gender);
            } catch (ParseException | NumberFormatException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private LocalDate parseDateOfBirth(String dateOfBirthString) throws ParseException {
        try {
            return LocalDate.parse(dateOfBirthString, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (Exception e) {
            throw new ParseException("Invalid date format");
        }
    }

    private long parsePhoneNumber(String phoneNumberString) throws ParseException {
        try {
            return Long.parseLong(phoneNumberString);
        } catch (NumberFormatException e) {
            throw new ParseException("Invalid phone number" );
        }
    }

    private GenderEnum parseGender(String genderString) throws ParseException {
        if (genderString.equalsIgnoreCase("m")){
            return GenderEnum.MALE;
        }
        else if (genderString.equalsIgnoreCase("f")){
            return GenderEnum.FEMALE;
        }
        else {
            throw new ParseException("Invalid gender");
        }
    }
}