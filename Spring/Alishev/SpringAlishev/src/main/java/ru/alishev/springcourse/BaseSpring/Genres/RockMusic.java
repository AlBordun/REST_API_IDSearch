package ru.alishev.springcourse.BaseSpring.Genres;

import ru.alishev.springcourse.BaseSpring.Music;

//@Component
//@Scope("prototype")
public class RockMusic implements Music {

    public String getSong() {
        return "Wind cries Mary";
    }

//    DZ2
//    private List<String> songs = new ArrayList<>();
//
//    // Блок инициализации объекта (англ. Instance initialization block)
//    // Выполняется каждый раз, когда создается объект класса
//    {
//        songs.add("Wind cries Mary");
//        songs.add("Paint it black");
//        songs.add("Can't seem to make you mine");
//    }
//
//    @Override
//    public List<String> getSongs() {
//        return songs;
//    }
}
