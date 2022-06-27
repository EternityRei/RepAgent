package controller.command.utils;

import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

public class CommandUtil {
    static Logger log = Logger.getLogger(CommandUtil.class);

    private CommandUtil() {

    }

    public static void goToPage(HttpServletRequest req, HttpServletResponse resp, String url) {
        System.out.println("Go to page method");
        //RequestDispatcher requestDispatcher = req.getRequestDispatcher(url);
        var requestDispatcher = req.getRequestDispatcher(url);
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            log.info(e);
        }
    }

    public static String getUserPageByRole(int accessLevel) {
        String page = "";
        switch (accessLevel) {
            case 1:
                page = "/WEB-INF/view/home.jsp";
                break;
            case 2:
                page = "/WEB-INF/view/customer.jsp";
                break;
            case 3:
                page = "/WEB-INF/view/employee.jsp";
                break;
            case 4:
                page = "/WEB-INF/view/manager.jsp";
                break;
            default:
        }
        return page;
    }

    public static Date getCurrentDate() {
        var cal = Calendar.getInstance();
        var sdf = new SimpleDateFormat("MM-dd-yyyy");
        String date = sdf.format(cal.getTime());
        return Date.from(Instant.parse(date));
    }

    public static Optional<String> encrypt(String pass) {
        try {
            var messageDigest = MessageDigest.getInstance("SHA-256");

            messageDigest.update(pass.getBytes());

            byte[] digest = messageDigest.digest();
            var stringBuilder = new StringBuilder();

            for (byte theByte : digest) {
                stringBuilder.append(String.format("%02x", theByte & 0xff));
            }
            return Optional.of(stringBuilder.toString());
        } catch (NoSuchAlgorithmException e) {
            log.info(e.getMessage());
        }
        return Optional.empty();
    }
}
