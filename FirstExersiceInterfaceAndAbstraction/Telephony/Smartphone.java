package FirstExersiceInterfaceAndAbstraction.Telephony;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Call,Browse{

    @Override
    public String browse(String url) {
        Pattern pattern = Pattern.compile("^[^0-9]*$");
        Matcher matcher = pattern.matcher(url);
        if (matcher.find()){
            return String.format("Browsing: %s!",url);
        }
        return "Invalid URL!";
    }

    @Override
    public  String call(String number) {
        Pattern pattern = Pattern.compile("^[0-9]*$");
        Matcher matcher = pattern.matcher(number);
        if (matcher.find()){
            return String.format("Calling... %s",number);
        }
        return "Invalid number!";
    }
}
