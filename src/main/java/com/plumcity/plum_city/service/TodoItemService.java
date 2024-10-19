package com.plumcity.plum_city.service;

import com.plumcity.plum_city.model.TodoItem;
import com.plumcity.plum_city.repository.TodoItemRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoItemService {

  private final TodoItemRepository todoItemRepository;

  public TodoItem createTodoItem(TodoItem todoItem) {
    return todoItemRepository.save(todoItem);
  }

  public List<TodoItem> getAllTodoItems() {
    return todoItemRepository.findAll();
  }
}
