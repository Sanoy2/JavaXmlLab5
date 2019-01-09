import java.time.Duration;
import java.time.Instant;

public class Timer
{
    private Instant start;
    private Instant finish;

    public void Start()
    {
        start = Instant.now();
    }

    public void Finish()
    {
        finish = Instant.now();
    }

    public long TimeInMS()
    {
        long timeElapsed = Duration.between(start, finish).toMillis();
        return timeElapsed;
    }
}
