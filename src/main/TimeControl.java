package main;

public class TimeControl {

    private static int updatesSinceStart;

    public TimeControl() {
        updatesSinceStart = 0;
    }

    public static void update() {
        updatesSinceStart++;
    }

    public static String getFormattedTime() {
        StringBuilder stringBuilder = new StringBuilder();
        int minutes = updatesSinceStart / 120 / 60;
        int seconds = updatesSinceStart / 120 % 60;
        int hours = updatesSinceStart / 120 / 60 / 60;
        if(hours < 10) {
            stringBuilder.append(0);
        }
        stringBuilder.append(hours);
        stringBuilder.append(":");

        if(minutes < 10) {
            stringBuilder.append(0);
        }
        stringBuilder.append(minutes);
        stringBuilder.append(":");

        if(seconds < 10) {
            stringBuilder.append(0);
        }
        stringBuilder.append(seconds);
        return stringBuilder.toString();
    }
}
