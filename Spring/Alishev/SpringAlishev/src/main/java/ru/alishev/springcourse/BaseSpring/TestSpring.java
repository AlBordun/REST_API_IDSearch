package ru.alishev.springcourse.BaseSpring;

//import jdk.javadoc.internal.doclets.toolkit.AnnotationTypeRequiredMemberWriter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.alishev.springcourse.BaseSpring.Config.SpringConfig;

public class TestSpring {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
//                "applicationContext.xml"
//        );
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class
        );
        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        System.out.println(musicPlayer.getName());
        System.out.println(musicPlayer.playMusic());
        System.out.println(musicPlayer.getVolume());

//        ClassicalMusic classicalMusic = context.getBean("classicalMusic", ClassicalMusic.class);
//        ClassicalMusic classicalMusic1 = context.getBean("classicalMusic", ClassicalMusic.class);
//
//        System.out.println(classicalMusic1 == classicalMusic);
//        DZ2
//        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//
//        musicPlayer.playMusic(MusicGenres.CLASSICAL);
//        musicPlayer.playMusic(MusicGenres.ROCK);


//        Computer computer = context.getBean("computer", Computer.class);
//        System.out.println(computer);

//        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//        musicPlayer.playMusic();

//            ClassicalMusic classicalMusic = context.getBean("musicBean", ClassicalMusic.class);
//            System.out.println(classicalMusic.getSong());

//        TestBean testBean = context.getBean("testBean", TestBean.class);
//        System.out.println(testBean.getName());

//        Music music = context.getBean("rockMusic", Music.class);
//
//        MusicPlayer musicPlayer = new MusicPlayer(music);
//        musicPlayer.playMusic();
//
//        Music music1 = context.getBean("classicalMusic", Music.class);
//
//        MusicPlayer classicalMusicPlayer = new MusicPlayer(music1);
//        classicalMusicPlayer.playMusic();

//        MusicPlayer firstMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//        MusicPlayer secondMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//
//        firstMusicPlayer.playMusicList();
//        secondMusicPlayer.playMusicList();
//
//        boolean comparison = firstMusicPlayer == secondMusicPlayer;
//        System.out.println(comparison);
//
//        System.out.println(firstMusicPlayer);
//        System.out.println(secondMusicPlayer);
//
//        firstMusicPlayer.setVolume(10);
//        System.out.println(firstMusicPlayer.getVolume());
//        System.out.println(secondMusicPlayer.getVolume());

//        System.out.println(musicPlayer.getName());
//        System.out.println(musicPlayer.getVolume());

        context.close();
    }

}
