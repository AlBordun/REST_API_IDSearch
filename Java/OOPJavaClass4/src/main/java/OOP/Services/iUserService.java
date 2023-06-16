package OOP.Services;

import java.util.*;

public interface iUserService<T> {
    List<T> getAll();
    void Create(String firstName,String lastName,int age);

}
