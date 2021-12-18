package ru.dimedrollo.Hometask19.repository;

import java.util.List;

/**
 * 15.11.2021
 * 20. Java IO
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface UsersRepository {
    List<User> findAll();
    void save(User user);
    List<User> findByAge(int age);
    List<User> findByIsWorkerIsTrue();
}
