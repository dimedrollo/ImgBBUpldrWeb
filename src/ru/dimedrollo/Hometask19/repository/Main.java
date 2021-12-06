package ru.dimedrollo.Hometask19.repository;

import java.util.List;

/**
 * 15.11.2021
 * 20. Java IO
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        UsersRepository usersRepository = new UsersRepositoryFileImpl("users.txt");
        List<User> coevals = usersRepository.findByAge(33);
        for (User user : coevals) {
            System.out.println(user.getAge() + " " + user.getName() + " " + user.isWorker());
        }

        List<User> workers = usersRepository.findByIsWorkerIsTrue();
        for (User user : workers) {
            System.out.println(user.getAge() + " " + user.getName() + " " + user.isWorker());
        }
    }
}
