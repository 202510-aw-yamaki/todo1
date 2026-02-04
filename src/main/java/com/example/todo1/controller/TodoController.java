package com.example.todo1.controller;

import com.example.todo1.form.TodoForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        if (!model.containsAttribute("todoForm")) {
            model.addAttribute("todoForm", new TodoForm());
        }
        return "todos/form";
    }

    // Receive submitted form data and redirect to the confirmation screen with flash attributes.
    @PostMapping("/todos/confirm")
    public String confirm(@ModelAttribute("todoForm") TodoForm todoForm,
                          RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("todoForm", todoForm);
        return "redirect:/todos/confirm";
    }

    // Show the confirmation screen (data is carried via RedirectAttributes).
    @GetMapping("/todos/confirm")
    public String confirmView(@ModelAttribute("todoForm") TodoForm todoForm) {
        return "todos/confirm";
    }

    // Return to the input screen while keeping input values.
    @PostMapping("/todos/back")
    public String back(@ModelAttribute("todoForm") TodoForm todoForm,
                       RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("todoForm", todoForm);
        return "redirect:/todos/new";
    }

    // Complete registration and redirect to the completion screen.
    @PostMapping("/todos/complete")
    public String complete(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("completed", true);
        return "redirect:/todos/complete";
    }

    // Show the completion screen.
    @GetMapping("/todos/complete")
    public String completeView() {
        return "todos/complete";
    }

    // Show the ToDo detail screen for the given id.
    @GetMapping("/todos/{id}")
    public String detail(@PathVariable("id") Long id) {
        return "todos/detail";
    }
}
