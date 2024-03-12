package com.example.springboottodoapp.services;

import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboottodoapp.models.TodoItem;
import com.example.springboottodoapp.repositories.TodoItemRepository;

@Service
public class TodoItemService {
    @Autowired
    private TodoItemRepository todoItemRepository;
    public Optional<TodoItem> getById(Long id){
        return todoItemRepository.findById(id);
    }
    public Iterable<TodoItem> getAll(){
        return todoItemRepository.findAll();
    }
    public TodoItem save(TodoItem todoItem){
        if(todoItem.getId()==null){
            todoItem.setCreatedAt(Instant.now());
        }
        todoItem.setUpdatedAt(Instant.now());
        return todoItemRepository.save(todoItem);
    }
    public void delete(TodoItem todoItem){
        todoItemRepository.delete(todoItem);
    }
    
}