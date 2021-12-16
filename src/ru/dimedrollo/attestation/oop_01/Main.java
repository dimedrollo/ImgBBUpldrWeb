package ru.dimedrollo.attestation.oop_01;


public class Main {
    public static void main(String[] args) {
        UsersRepository usersRepository = new UsersRepositoryFileImpl("users.txt");

        System.out.println(usersRepository.findById(02).getName() + " " + usersRepository.findById(02).getAge());

        User user = new User(2, "Трамп", 75, true);

        usersRepository.update(user);

        System.out.println(usersRepository.findById(02).getName() + " " + usersRepository.findById(02).getAge());

    }
}
