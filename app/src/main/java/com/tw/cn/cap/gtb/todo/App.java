/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.tw.cn.cap.gtb.todo;

import org.checkerframework.checker.units.qual.A;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
    }

    public List<String> run() throws IOException {
        List<String> result = new ArrayList<>();
        List<String> readLines = Files.readAllLines(Path.of("C:\\Users\\tiandingyi\\Desktop\\TW-GTB\\assignment-todo-java-tdd\\tasks"));
        List<String> todoList = new ArrayList<>();
        List<String> completedList = new ArrayList<>();
        for (int i = 0; i < readLines.size(); i++) {
            int id = i + 1;
            String line = readLines.get(i);
            String name = line.substring(2);
            if (readLines.get(i).charAt(0) == '+') {
                todoList.add(formaTask(new Task(id, name)));
            } else {
                completedList.add(formaTask(new Task(id, name)));
            }
        }
        result.add("#To be done");
        if (todoList.size() == 0) {
            result.add("Empty");
        } else {
            todoList.forEach(task -> result.add(task));
        }
        result.add("#Completed");
        if (completedList.size() == 0) {
            result.add("Empty");
        } else {
            completedList.forEach(task -> result.add(task));
        }
        return result;
    }
    private String formaTask(Task task) {
        return task.getId() + " " + task.getName();
    }
}
