package ru.alishev.springcourse.BaseSpring;

import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//@Component
public class MusicPlayer {
    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;
    private Music music1;
    private Music music2;

    //    @Autowired
//    public MusicPlayer(@Qualifier("rockMusic") Music music1,
//                       @Qualifier("classicalMusic") Music music2) {
//        this.music1 = music1;
//        this.music2 = music2;
//    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    // DZ3
    private List<Music> musicList = new ArrayList<>();

    public MusicPlayer(List<Music> musicList) {
        this.musicList = musicList;
    }

    public String playMusic() {
        Random random = new Random();
        return "Playing: " + musicList.get(random.nextInt(musicList.size())).getSong() + " " +
                "with volume: " + this.volume;
    }
    //    DZ2
//    private ClassicalMusic classicalMusic;
//    private RockMusic rockMusic;
//
//
//    @Autowired
//    public MusicPlayer(ClassicalMusic classicalMusic, RockMusic rockMusic) {
//        this.classicalMusic = classicalMusic;
//        this.rockMusic = rockMusic;
//    }
//DZ2
//    public void playMusic(MusicGenres genres) {
//        Random random = new Random();
//
//        // случайное целое число между 0 и 2
//        int randomNumber = random.nextInt(3);
//
//        if (genres == MusicGenres.CLASSICAL) {
//            // случайная классическая песня
//            System.out.println(classicalMusic.getSongs().get(randomNumber));
//        } else {
//            // случайная рок песня
//            System.out.println(rockMusic.getSongs().get(randomNumber));
//        }
//    }
//    @Autowired
//    @Qualifier("classicalMusic")
//    private Music music;
//    private String name;
//    private int volume;

    //    private ClassicalMusic classicalMusic;
//    private RockMusic rockMusic;

//    @Autowired
//    public MusicPlayer(ClassicalMusic classicalMusic, RockMusic rockMusic) {
//        this.classicalMusic = classicalMusic;
//        this.rockMusic = rockMusic;
//    }

    //IoC
//    public MusicPlayer(Music music) {
//        this.music = music;
//    }

//    @Autowired
//    public void setMusic(Music music) {
//        this.music = music;
//    }
//    public void setMusic(Music music) {
//        this.music = music;
//    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getVolume() {
//        return volume;
//    }
//
//    public void setVolume(int volume) {
//        this.volume = volume;
//    }

//    public String playMusic() {
//        return "playing: " + music1.getSong() + ", " + music2.getSong();
//        return "playing: " + classicalMusic.getSong();
//        System.out.println("playing: " + rockMusic.getSong());
//    }

//    public MusicPlayer() {
//    }

//    public void setMusicList(List<Music> musicList) {
//        this.musicList = musicList;
//    }
//
//    public void playMusicList() {
//        for (Music music : musicList) {
//            System.out.println("Playing: " + music.getSong());
//}
//    }
}
