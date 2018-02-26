package by.lk.controller;

import by.lk.dto.TaskDto;
import by.lk.entity.Task;
import by.lk.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by Vinty on 22.02.2018
 */
@Controller
public class HelpDeskController {
    private final TaskService taskService;

    @Autowired
    public HelpDeskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @ModelAttribute("taskDto")
    public TaskDto taskDto(){
        return new TaskDto();
    }

    @GetMapping(path = "/HelpDesk")
    public String showHelpDesk() {
        return "HelpDesk";
    }

    @PostMapping(path = "/HelpDesk")
    public String taskDto(TaskDto taskDto, Model model) {
        taskDto.setTypeOfJobId(1L);
        taskService.saveTask(taskDto);
        return "HelpDesk";
    }
}
