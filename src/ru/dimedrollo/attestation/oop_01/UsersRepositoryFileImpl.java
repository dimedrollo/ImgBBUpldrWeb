package ru.dimedrollo.attestation.oop_01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class UsersRepositoryFileImpl implements UsersRepository {

    private String fileName;

    public UsersRepositoryFileImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public User findById(int id) {
        Reader reader = null;
        BufferedReader buffReader = null;
        User userFromId = null;
        try {
            buffReader = new BufferedReader(new FileReader(fileName));
            String line = buffReader.readLine();
            while (line != null) {
                String[] rowData = line.split("\\|");
                if (Integer.parseInt(rowData[0]) == id) {
                    userFromId = new User(id, rowData[1], Integer.parseInt(rowData[2]), Boolean.parseBoolean(rowData[3]));
                }
                line = buffReader.readLine();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                }
            }
            if (buffReader != null) {
                try {
                    buffReader.close();
                } catch (IOException e) {
                }
            }
        }
        return userFromId;
    }


    @Override
    public void update(User newUser) {
        Reader reader = null;
        BufferedReader buffReader = null;
        List<User> usersFromFileList = new ArrayList<>();
        try {
            buffReader = new BufferedReader(new FileReader(fileName));
            String line = buffReader.readLine();
            while (line != null) {
                String[] rowData = line.split("\\|");
                usersFromFileList.add(new User(Integer.parseInt(rowData[0]), rowData[1], Integer.parseInt(rowData[2]), Boolean.parseBoolean(rowData[3])));
                line = buffReader.readLine();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                }
            }
            if (buffReader != null) {
                try {
                    buffReader.close();
                } catch (IOException e) {
                }
            }
        }
        Writer writer = null;
        BufferedWriter bufferedWriter = null;
        try {
            writer = new FileWriter(fileName);
            bufferedWriter = new BufferedWriter(writer);
            for (User currentUser : usersFromFileList) {
                if (currentUser.getId() == newUser.getId()) {
                    currentUser = newUser;
                }
                bufferedWriter.write(currentUser.toString());
                bufferedWriter.flush();
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException ignore) {
                }
            }
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException ignore) {
                }
            }
        }
    }
}
