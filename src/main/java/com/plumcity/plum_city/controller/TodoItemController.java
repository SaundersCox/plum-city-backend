package com.plumcity.plum_city.controller;

import com.plumcity.plum_city.model.TodoItem;
import com.plumcity.plum_city.service.TodoItemService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/todo")
@RequiredArgsConstructor
public class TodoItemController {

  private final TodoItemService todoItemService;

  @PostMapping
  public ResponseEntity<TodoItem> createTodoItem(@RequestBody TodoItem todoItem) {
    TodoItem createdTodoItem = todoItemService.createTodoItem(todoItem);
    return new ResponseEntity<>(createdTodoItem, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<TodoItem>> getTodoItems() {
    List<TodoItem> todoItems = todoItemService.getAllTodoItems();
    return ResponseEntity.ok(todoItems);
  }
}
