package net.tatsuyagi.spring.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.tatsuyagi.spring.sample.form.TodoForm;
import net.tatsuyagi.spring.sample.service.TodoService;
import net.tatsuyagi.spring.sample.view.TodoView;

@Slf4j
@Controller
@AllArgsConstructor
public class TodoController {
    
    private final TodoService todoService;

    @GetMapping("/")
    public String root() {
        return "redirect:index";
    }

    @GetMapping("/index")
    public TodoView index(TodoView view) {

        if(!view.getModelMap().containsAttribute(ClassUtils.getShortNameAsProperty(TodoForm.class))) {
            view.getModelMap().addAttribute(new TodoForm());
        }
        // 検索結果をモデルにセット
        view.addObject("todoList", todoService.findAll());

        return view;
    }

    @PostMapping("/register")
    public String register(@Validated TodoForm form, BindingResult result, RedirectAttributes ra) {

        log.info("登録開始");

        todoService.save(form).ifPresent(entity -> {
            ra.addFlashAttribute("resultMsg", "新しいTODO 「" + entity.getTitle() + "」を登録しました。");
        });
        return "redirect:index";
    }

    @PostMapping("/delete")
    public String delete(@RequestBody MultiValueMap<String, String> request,
            BindingResult result, RedirectAttributes ra) {
        log.info("削除開始");

        todoService.deleteById(Integer.parseInt(request.getFirst("id")));

        ra.addFlashAttribute("resultMsg", "TODOを削除しました。");

        return "redirect:index";
    }
}
