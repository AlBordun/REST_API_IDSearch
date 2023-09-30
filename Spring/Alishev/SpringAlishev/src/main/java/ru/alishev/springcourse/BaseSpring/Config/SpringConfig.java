package ru.alishev.springcourse.BaseSpring.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.alishev.springcourse.BaseSpring.Computer;
import ru.alishev.springcourse.BaseSpring.Genres.ClassicalMusic;
import ru.alishev.springcourse.BaseSpring.Genres.ElectronicMusic;
import ru.alishev.springcourse.BaseSpring.Genres.RockMusic;
import ru.alishev.springcourse.BaseSpring.Music;
import ru.alishev.springcourse.BaseSpring.MusicPlayer;

import java.util.*;
import java.util.Arrays;

@Configuration
@ComponentScan("ru.alishev.springcourse")
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {
    @Bean
    public ClassicalMusic classicalMusic() {
        return new ClassicalMusic();
    }

    @Bean
    public RockMusic rockMusic() {
        return new RockMusic();
    }

    @Bean
    public ElectronicMusic electronicMusic() {
        return new ElectronicMusic();
    }

    @Bean
//    public MusicPlayer musicPlayer() {
//        return new MusicPlayer(rockMusic(), classicalMusic());
//    }
    public MusicPlayer musicPlayer() {
        return new MusicPlayer(musicList());
    }
    @Bean
    public List<Music> musicList() {
        return Arrays.asList(classicalMusic(), rockMusic(), electronicMusic());
    }

    @Bean
    Computer computer() {
        return new Computer(musicPlayer());
    }
}
