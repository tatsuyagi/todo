package net.tatsuyagi.spring.sample.service;

import java.util.List;
import java.util.Optional;

import net.tatsuyagi.spring.sample.form.TodoForm;
import net.tatsuyagi.spring.sample.model.entity.Todo;

public interface TodoService {
    
    /**
     * 全てのTODOを取得する.
     * @return TODOリスト
     */
    List<Todo> findAll();

    /**
     * ID指定でTODOを取得する.
     * @param id ID
     * @return TODOデータ
     */
    Optional<Todo> findById(Integer id);
    
    /**
     * TODOの登録/更新.
     * @return 登録/更新したデータ
     */
    Optional<Todo> save(TodoForm form);

    /**
     * IDで削除する.
     * @param id
     */
    default void deleteById(Integer id) {
        deleteByIds(List.of(id));
    }

    /**
     * IDリストで削除する.
     * @param ids
     */
    void deleteByIds(List<Integer> ids);

}
