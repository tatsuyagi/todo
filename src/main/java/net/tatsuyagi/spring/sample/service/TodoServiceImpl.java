package net.tatsuyagi.spring.sample.service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.tatsuyagi.spring.sample.form.TodoForm;
import net.tatsuyagi.spring.sample.model.entity.Todo;
import net.tatsuyagi.spring.sample.model.repository.TodoRepository;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    /** TODOリポジトリ. */
    private final TodoRepository todoRepos;

    @Override
    public List<Todo> findAll() {
        return todoRepos.findAll().stream()
            .sorted(Comparator.comparing(Todo::getLimitTime, Comparator.nullsFirst(Comparator.naturalOrder())))
            .collect(Collectors.toList());
    }

    @Override
    public Optional<Todo> findById(Integer id) {
        return todoRepos.findById(id);
    }

    @Override
    public Optional<Todo> save(TodoForm form) {
        Todo target = Todo.builder()
            .title(form.getTitle())
            .description(form.getDescription())
            .limitTime(LocalDateTime.of(form.getLimit(), LocalTime.MIN))
            .build();
        return Optional.of(todoRepos.saveAndFlush(target));
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        todoRepos.deleteAll(todoRepos.findAllById(ids));
    }

}
