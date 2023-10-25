import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ResumeBuilder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Console Resume Builder!");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.println("Enter your education (one per line, type 'done' when finished):");
        StringBuilder education = new StringBuilder();
        String line;
        while (true) {
            line = scanner.nextLine();
            if (line.equalsIgnoreCase("done")) {
                break;
            }
            education.append(line).append("\n");
        }

        System.out.println("Enter your experience (one per line, type 'done' when finished):");
        StringBuilder experience = new StringBuilder();
        while (true) {
            line = scanner.nextLine();
            if (line.equalsIgnoreCase("done")) {
                break;
            }
            experience.append(line).append("\n");
        }

        // Generate the resume
        String resumeText = generateResume(name, email, education.toString(), experience.toString());

        // Save the resume to a file (e.g., resume.txt)
        try (FileWriter writer = new FileWriter("resume.txt")) {
            writer.write(resumeText);
        } catch (IOException e) {
            System.err.println("Error writing the resume to a file: " + e.getMessage());
        }

        System.out.println("Your resume has been generated and saved as 'resume.txt'.");
    }

    private static String generateResume(String name, String email, String education, String experience) {
        StringBuilder resume = new StringBuilder();
        resume.append("Resume\n\n");
        resume.append("Name: ").append(name).append("\n");
        resume.append("Email: ").append(email).append("\n\n");
        resume.append("Education:\n").append(education).append("\n");
        resume.append("Experience:\n").append(experience).append("\n");
        return resume.toString();
    }
}
