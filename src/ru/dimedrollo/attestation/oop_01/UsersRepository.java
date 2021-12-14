package ru.dimedrollo.attestation.oop_01;

import java.util.List;


public interface UsersRepository {
    //  List<User> findAll();
    //  void save(User user);
    //  List<User> findByAge(int age);
    //  List<User> findByIsWorkerIsTrue();
    User findById(int id);

    void update(User user);
}
