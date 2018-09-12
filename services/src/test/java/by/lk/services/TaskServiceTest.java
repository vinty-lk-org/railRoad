package by.lk.services;

import by.lk.dto.TaskDto;
import by.lk.entity.Task;
import by.lk.repository.TaskRepository;
import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNull;


public class TaskServiceTest extends CommonTest {
    private Long id;
    @Autowired
    private TaskService taskService;
    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void saveTaskTest() {
        TaskDto taskDto = new TaskDto();
        taskDto.setName("Подсоединить картридж");
        taskDto.setText("Закончился старый картридж. Надо замена.");
        id = taskService.saveTask(taskDto);
        taskRepository.delete(id);
    }

    @Test
    public void findAllTest(){
//        TaskDto taskDto = new TaskDto();
//        taskDto.setName("Подсоединить картридж");
//        taskDto.setText("Закончился старый картридж. Надо замена.");
//        taskDto.setTypeOfJobId(1L);
//
//        TaskDto taskDto2 = new TaskDto();
//        taskDto2.setName("Подсоединить картридж");
//        taskDto2.setText("Закончился старый картридж. Надо замена.");
//        taskDto2.setTypeOfJobId(1L);
//
//        id = taskService.saveTask(taskDto);
//        Long id2 = taskService.saveTask(taskDto2);
//        List<TaskDto> taskDtoList = new ArrayList<>();
//        taskDtoList.add(taskDto);
//        taskDtoList.add(taskDto2);

//        List<TaskDto> taskDtoListFromDb = taskService.findAll();
//        System.out.println(taskDtoListFromDb);
//        taskRepository.delete(id2);
    }
}
