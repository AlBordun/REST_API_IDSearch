package ru.alishev.springcourse.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.alishev.springcourse.Models.Person;

import java.sql.*;
import java.util.*;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    private static int PEOPLE_COUNT;
//    private List<Person> people;

//    {
//        people = new ArrayList<>();
//
//        people.add(new Person(++PEOPLE_COUNT, "Biba", 22, "111@Gmail.com"));
//        people.add(new Person(++PEOPLE_COUNT, "Boba", 23, "222@Gmail.com"));
//        people.add(new Person(++PEOPLE_COUNT, "Dva", 24, "333@Gmail.com"));
//        people.add(new Person(++PEOPLE_COUNT, "Genia", 25, "444@Gmail.com"));
//    }

//    private static final String URL = "jdbc:postgresql://localhost:5432/first_db";
//    private static final String USERNAME = "postgres";
//    private static final String PASSWORD = "admin";
//
//    private static Connection connection;
//
//    static {
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//    }


    public List<Person> index() throws SQLException {

        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));

//        List<Person> people = new ArrayList<>();
//
//        Statement statement = connection.createStatement();
//        String SQL = "SELECT * FROM Person";
//        statement.executeQuery(SQL);
//        ResultSet resultSet = statement.executeQuery(SQL);
//
//        while (resultSet.next()) {
//            Person person = new Person();
//
//            person.setId(resultSet.getInt("id"));
//            person.setName(resultSet.getString("name"));
//            person.setEmail(resultSet.getString("email"));
//            person.setAge(resultSet.getInt("age"));
//
//            people.add(person);
//        }
//        return people;
    }

    public Person show(int id) throws SQLException {

        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[]{id},
                        new BeanPropertyRowMapper<>(Person.class))
                                            .stream().findAny().orElse(null);



//        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
//        Person person = new Person();
//        PreparedStatement preparedStatement =
//                connection.prepareStatement("SELECT * FROM Person WHERE id = ?");
//        preparedStatement.setInt(1, id);
//        ResultSet resultSet = preparedStatement.executeQuery();
//
//        resultSet.next();
//
//        person.setId(resultSet.getInt("id"));
//        person.setName(resultSet.getString("name"));
//        person.setEmail(resultSet.getString("email"));
//        person.setAge(resultSet.getInt("age"));
//
//        return person;
    }

    public void save(Person person) throws SQLException {

        jdbcTemplate.update("INSERT INTO Person VALUES (1,?,?,?)", person.getName(), person.getEmail(),person.getAge());

//        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Person VALUES (1,?,?,?)");
//
//        preparedStatement.setString(1, person.getName());
//        preparedStatement.setString(2, person.getEmail());
//        preparedStatement.setInt(3, person.getAge());

//        Statement statement = connection.createStatement();
//        String SQL = "INSERT INTO Person VALUES(" + 1 + ",'" + person.getName() +
//                "'," + person.getAge() + ",'" + person.getEmail() + "')";

//        preparedStatement.executeUpdate();
//        person.setId(++PEOPLE_COUNT);
//        people.add(person);
    }

    public void update(int id, Person updatedPerson) throws SQLException {

        jdbcTemplate.update("UPDATE Person SET name=?,email=?,age=? WHERE id=?",
                updatedPerson.getName(),updatedPerson.getEmail(),updatedPerson.getAge(), id);
//        Person personToBeUpdated = show(id);
//
//        personToBeUpdated.setName(updatedPerson.getName());
//        personToBeUpdated.setAge(updatedPerson.getAge());
//        personToBeUpdated.setEmail(updatedPerson.getEmail());

//        PreparedStatement preparedStatement =
//                connection.prepareStatement("UPDATE Person SET name=?,email=?,age=? WHERE id = ?");
//        preparedStatement.setString(1, updatedPerson.getName());
//        preparedStatement.setString(2, updatedPerson.getEmail());
//        preparedStatement.setInt(3, updatedPerson.getAge());
//        preparedStatement.setInt(4, id);
//
//        preparedStatement.executeUpdate();
    }

    public void delete(int id) throws SQLException {

        jdbcTemplate.update("DELETE FROM Person WHERE id=?",id);

//        people.removeIf(p -> p.getId() == id);

//        PreparedStatement preparedStatement =
//                connection.prepareStatement("DELETE FROM Person WHERE id=?");
//
//        preparedStatement.setInt(1, id);
//
//        preparedStatement.executeUpdate();
    }
}
