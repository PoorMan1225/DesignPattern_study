package Chapter03;


public class FakeTimeReminder implements Alarm {
    private Mp3 mp3;
    @Override
    public void reminder() {
        mp3 = new Mp3();
        mp3.playSong();
    }
}
