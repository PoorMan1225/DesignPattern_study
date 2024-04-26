package Chapter03;

import java.util.Calendar;

public class TimeReminder implements Alarm {
    private Mp3 mp3;

    @Override
    public void reminder() {
        Calendar calendar = Calendar.getInstance();
        mp3 = new Mp3();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        if(hour >= 22) mp3.playSong();
    }
}
