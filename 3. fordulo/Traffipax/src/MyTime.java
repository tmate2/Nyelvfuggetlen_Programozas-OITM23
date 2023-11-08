import java.util.Objects;


public class MyTime {

    private int hour;
    private int minutes;
    private int seconds;


    public MyTime(int hour, int minutes, int seconds) {
        this.hour = hour;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public static MyTime timeFromSec(int seconds) {
        int sec = seconds%60;
        int min = (seconds / 60) % 60;
        int hr = (seconds / 60) / 60;

        return new MyTime(hr, min, sec);
    }

    public int timeToSec() {
        return this.hour * 3600 + this.minutes * 60 + this.seconds;
    }

    public MyTime addTime(MyTime o) {
        int sec = this.seconds + o.seconds;
        int min = this.minutes + o.minutes;
        int hr = this.hour + o.hour;
        return new MyTime((hr + min/60)%24, (min+(sec/60)) % 60, sec % 60);
    }

    public MyTime minusTime(MyTime o) {
        int sec = this.seconds - o.seconds;
        int min = this.minutes - o.minutes;

        if (sec < 0) {
            min -= 1;
            sec += 60;
        }

        int hr = this.hour - o.hour;

        if (min < 0) {
            hr -= 1;
            min += 60;
        }

        if ( hr < 0)
            hr += 24;

        return new MyTime(hr, min, sec);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyTime time = (MyTime) o;
        return this.hour == time.hour && this.minutes == time.minutes && this.seconds == time.seconds;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.hour, this.minutes, this.seconds);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.hour).append(":").append(this.minutes).append(":").append(this.seconds);
        return sb.toString();
    }

}
