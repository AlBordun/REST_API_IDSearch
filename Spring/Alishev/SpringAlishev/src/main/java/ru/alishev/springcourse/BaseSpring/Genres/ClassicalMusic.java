package ru.alishev.springcourse.BaseSpring.Genres;

import ru.alishev.springcourse.BaseSpring.Music;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component
public class ClassicalMusic implements Music {
    public ClassicalMusic() {
    }

    public static ClassicalMusic getClassicalMusic() {
        return new ClassicalMusic();
    }

    @PostConstruct
    public void doMyInit() {
        System.out.println("Doing my initialization");
    }

    @PreDestroy
    public void doMyDestroy() {
        System.out.println("Doing my destruction");
    }
//    DZ2
//    private List<String> songs = new ArrayList<>();
//
//    // Блок инициализации объекта (англ. Instance initialization block)
//    // Выполняется каждый раз, когда создается объект класса
//    {
//        songs.add("Hungarian Rhapsody");
//        songs.add("Symphony no. 5 in C Minor, op. 67");
//        songs.add("Night on Bald Mountain");
//    }
//
//    @Override
//    public List<String> getSongs() {
//        return songs;
//    }


    @Override
    public String getSong() {
        return "Hungarian Rhapsody";
    }
//
//    public void doMyInit() {
//        System.out.println("do my initialization");
//    }
//
//    public void doMyDestroy() {
//        System.out.println("do my destruction");
//    }

}
