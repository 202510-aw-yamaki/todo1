package com.example.todo1.controller;

import com.example.todo1.form.TodoForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TodoController {

    // Show the ToDo list screen.
    @GetMapping("/todos")
    public String list() {
        return "todos/list";
    }

    // Initialize the form object and show the input screen.
    @GetMapping("/todos/new")
    public String newTodo(Model model) {
        model.addAttribute("todoForm", new TodoForm());
        return "todos/form";
    }

    // Receive submitted form data and show a confirmation screen.
    @PostMapping("/todos/confirm")
    public String confirm(@ModelAttribute("todoForm") TodoForm todoForm) {
        return "todos/confirm";
    }

    // Show the ToDo detail screen for the given id.
    @GetMapping("/todos/{id}")
    public String detail(@PathVariable("id") Long id) {
        return "todos/detail";
    }
}
