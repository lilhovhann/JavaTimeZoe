import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class Converter {
    public static void main(String[] args) {
        List<String> zoneList = new ArrayList<>();


        String[] ids = TimeZone.getAvailableIDs();
        for (String id : ids) {
            String zone = displayTimeZone(TimeZone.getTimeZone(id));
            zoneList.add(zone);
        }


    }


    private static String displayTimeZone(TimeZone tz) {

        long hours = TimeUnit.MILLISECONDS.toHours(tz.getRawOffset());
        long minutes = TimeUnit.MILLISECONDS.toMinutes(tz.getRawOffset())
                - TimeUnit.HOURS.toMinutes(hours);
        minutes = Math.abs(minutes);

        String result = "";
        if (hours > 0) {
            result = String.format("(GMT+%d:%02d) %s", hours, minutes, tz.getID());
        } else {
            result = String.format("(GMT%d:%02d) %s", hours, minutes, tz.getID());
        }

        return result;

    }
}
