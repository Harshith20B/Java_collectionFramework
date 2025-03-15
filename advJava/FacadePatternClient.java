package advJava;
import java.util.*;
public interface TheaterDevice {
    void setupDevice();
    void startOperation();
    void stopOperation();
}

class MovieSystem implements TheaterDevice {
    private PopcornPopper popper;
    private Lights lights;
    private Screen screen;
    private Projector projector;
    private Amplifier amp;
    private DvdPlayer dvd;

    public MovieSystem() {
        popper = new PopcornPopper();
        lights = new Lights();
        screen = new Screen();
        projector = new Projector();
        amp = new Amplifier();
        dvd = new DvdPlayer();
    }

    @Override
    public void setupDevice() {
        System.out.println("Setting up Movie System...");
        popper.on();
        lights.dim(10);
        screen.down();
        projector.on();
        projector.setWideScreenMode();
        amp.on();
        amp.setSurroundSound();
    }

    @Override
    public void startOperation() {
        System.out.println("Starting Movie...");
        dvd.on();
        dvd.play("Movie");
    }

    @Override
    public void stopOperation() {
        System.out.println("Stopping Movie System...");
        dvd.stop();
        dvd.off();
        popper.off();
        lights.brighten();
        screen.up();
        projector.off();
        amp.off();
    }
}

class MusicSystem implements TheaterDevice {
    private Amplifier amp;
    private Lights lights;

    public MusicSystem() {
        amp = new Amplifier();
        lights = new Lights();
    }

    @Override
    public void setupDevice() {
        System.out.println("Setting up Music System...");
        lights.dim(20);
        amp.on();
        amp.setInput("CD");
    }

    @Override
    public void startOperation() {
        System.out.println("Starting Music...");
        amp.setVolume(5);
    }

    @Override
    public void stopOperation() {
        System.out.println("Stopping Music System...");
        amp.off();
        lights.brighten();
    }
}

class RadioSystem implements TheaterDevice {
    private Amplifier amp;

    public RadioSystem() {
        amp = new Amplifier();
    }

    @Override
    public void setupDevice() {
        System.out.println("Setting up Radio System...");
        amp.on();
        amp.setInput("Radio");
    }

    @Override
    public void startOperation() {
        System.out.println("Starting Radio...");
        amp.setVolume(3);
    }

    @Override
    public void stopOperation() {
        System.out.println("Stopping Radio System...");
        amp.off();
    }
}

class TheaterKeeper {
    private TheaterDevice movie;
    private TheaterDevice music;
    private TheaterDevice radio;

    public TheaterKeeper() {
        movie = new MovieSystem();
        music = new MusicSystem();
        radio = new RadioSystem();
    }

    public void movieOperation() {
        movie.setupDevice();
        movie.startOperation();
    }

    public void musicOperation() {
        music.setupDevice();
        music.startOperation();
    }

    public void radioOperation() {
        radio.setupDevice();
        radio.startOperation();
    }

    public void stopMovie() {
        movie.stopOperation();
    }

    public void stopMusic() {
        music.stopOperation();
    }

    public void stopRadio() {
        radio.stopOperation();
    }
}
public class FacadePatternClient {
    public static void main(String[] args) {
        TheaterKeeper keeper = new TheaterKeeper();
        System.out.println("=== Starting Movie Experience ===");
        keeper.movieOperation();
        
        System.out.println("\n=== Movie Finished ===");
        keeper.stopMovie();

        System.out.println("\n=== Starting Music Experience ===");
        keeper.musicOperation();
        
        System.out.println("\n=== Music Finished ===");
        keeper.stopMusic();
    }
}
 {
    
}
