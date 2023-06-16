package OOP.Controllers;

import OOP.StudentDomen.User;

public interface iUserController<T extends User>  {
    void Create(String firstName, String lastName, int age);
}
