package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.domain.TrelloCard;
import com.crud.tasks.domain.TrelloCardDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskMapperTest {
    
    @Autowired
    private TaskMapper taskMapper;

    @Test
    void testMapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "Test Title", "Test Content");
        Task taskTest = new Task(1L, "Test Title", "Test Content");

        //When
        Task task = taskMapper.mapToTask(taskDto);

        //Then
        assertEquals(task.getId(), taskTest.getId());
        assertEquals(task.getTitle(), taskTest.getTitle());
        assertEquals(task.getContent(), taskTest.getContent());
    }

    @Test
    void testMapToTaskDto() {
        //Given
        Task task = new Task(1L, "Title", "Content");
        TaskDto taskDtoTest = new TaskDto(1L, "Title", "Content");

        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);

        //Then
        assertEquals(taskDto.getId(), taskDtoTest.getId());
        assertEquals(taskDto.getTitle(), taskDtoTest.getTitle());
        assertEquals(taskDto.getContent(), taskDtoTest.getContent());
    }

    @Test
    void testMapToTaskDtoList() {
        //Given
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task(1L, "Title 1", "Content"));
        taskList.add(new Task(2L, "Title 2", "Content"));
        
        List<TaskDto> taskDtoListTest = new ArrayList<>();
        taskDtoListTest.add(new TaskDto(1L, "Title 1", "Content"));
        taskDtoListTest.add(new TaskDto(2L, "Title 2", "Content"));

        //When
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(taskList);

        //Then
        assertEquals(taskDtoList.get(0).getId(), taskDtoListTest.get(0).getId());
        assertEquals(taskDtoList.get(0).getTitle(), taskDtoListTest.get(0).getTitle());
        assertEquals(taskDtoList.get(0).getContent(), taskDtoListTest.get(0).getContent());
    }
    
    @Test
    void testMapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("Test", "Description", "top", "1");
        TrelloCardDto trelloCardDtoTest = new TrelloCardDto("Test", "Description", "top", "1");

        //When
        TrelloCardDto trelloCardDto = taskMapper.mapToCardDto(trelloCard);

        //Then
        assertEquals(trelloCardDto.getName(), trelloCardDtoTest.getName());
        assertEquals(trelloCardDto.getDescription(), trelloCardDtoTest.getDescription());
        assertEquals(trelloCardDto.getListId(), trelloCardDtoTest.getListId());
    }

    @Test
    void testMapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("Test", "Description", "top", "1");
        TrelloCard trelloCardTest = new TrelloCard("Test", "Description", "top", "1");

        //When
        TrelloCard trelloCard = taskMapper.mapToCard(trelloCardDto);

        //Then
        assertEquals(trelloCard.getName(), trelloCardTest.getName());
        assertEquals(trelloCard.getDescription(), trelloCardTest.getDescription());
        assertEquals(trelloCard.getPos(), trelloCardTest.getPos());
    }
}
