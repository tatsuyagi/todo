package net.tatsuyagi.spring.sample.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * TOODテーブル.
 */
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_todo")
public class Todo {
    
    /** ID. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /** TODOタイトル. */
    @Column(name = "title")
    private String title;

    /** TODO内容. */
    @Column(name = "description")
    private String description;

    /** 期限. */
    @Column(name = "limit_time")
    private LocalDateTime limitTime;

    /** 完了フラグ. */
    @Column(name = "completed")
    private boolean completed;

}
