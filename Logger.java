import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    private static final String LOG_FILE_PATH = "log.txt";

    public static void log(User user, String message) {
        try (FileWriter fileWriter = new FileWriter(LOG_FILE_PATH, true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {

            String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            String logMessage = "[" + timeStamp + "] User: " + user.getName() + " - " + message;

            System.out.println(logMessage); 
            printWriter.println(logMessage);

        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }
}
