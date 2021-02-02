package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TrelloMapperTest {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    void mapToBoards() {
        //Given
        TrelloListDto trelloListDto1 = new TrelloListDto();
        trelloListDto1.setId("1");
        trelloListDto1.setName("Test");
        trelloListDto1.setClosed(true);

        List<TrelloListDto> trelloListDtoList = new ArrayList<>();
        trelloListDtoList.add(trelloListDto1);

        TrelloBoardDto trelloBoardDto = new TrelloBoardDto();
        trelloBoardDto.setId("1");
        trelloBoardDto.setName("Test One");
        trelloBoardDto.setLists(trelloListDtoList);

        List<TrelloBoardDto> trelloBoardDtoList = new ArrayList<>();
        trelloBoardDtoList.add(trelloBoardDto);

        TrelloList trelloList = new TrelloList();
        trelloList.setId("1");
        trelloList.setName("Test");
        trelloList.setClosed(true);

        List<TrelloList> trelloListList = new ArrayList<>();
        trelloListList.add(trelloList);

        TrelloBoard trelloBoard = new TrelloBoard();
        trelloBoard.setId("1");
        trelloBoard.setName("Test One");
        trelloBoard.setLists(trelloListList);

        List<TrelloBoard> testList = new ArrayList<>();
        testList.add(trelloBoard);

        //When
        List<TrelloBoard> trelloBoardList = trelloMapper.mapToBoards(trelloBoardDtoList);

        //Then
        assertEquals(testList.get(0), trelloBoardList.get(0));
    }

    @Test
    void mapToBoardsDto() {
        //Given
        TrelloList trelloList = new TrelloList();
        trelloList.setId("1");
        trelloList.setName("Test");
        trelloList.setClosed(true);

        List<TrelloList> trelloListList = new ArrayList<>();
        trelloListList.add(trelloList);

        TrelloBoard trelloBoard = new TrelloBoard();
        trelloBoard.setId("1");
        trelloBoard.setName("Test One");
        trelloBoard.setLists(trelloListList);

        List<TrelloBoard> trelloBoardList = new ArrayList<>();
        trelloBoardList.add(trelloBoard);

        TrelloListDto trelloListDto1 = new TrelloListDto();
        trelloListDto1.setId("1");
        trelloListDto1.setName("Test");
        trelloListDto1.setClosed(true);

        List<TrelloListDto> trelloListDtoList = new ArrayList<>();
        trelloListDtoList.add(trelloListDto1);

        TrelloBoardDto trelloBoardDto = new TrelloBoardDto();
        trelloBoardDto.setId("1");
        trelloBoardDto.setName("Test One");
        trelloBoardDto.setLists(trelloListDtoList);

        List<TrelloBoardDto> testList = new ArrayList<>();
        testList.add(trelloBoardDto);

        //When
        List<TrelloBoardDto> boardDtoList = trelloMapper.mapToBoardsDto(trelloBoardList);

        //Then
        assertEquals(boardDtoList, testList);
    }

    @Test
    void mapToList() {
        //Given
        TrelloListDto trelloListDto1 = new TrelloListDto();
        trelloListDto1.setId("1");
        trelloListDto1.setName("Test");
        trelloListDto1.setClosed(true);

        List<TrelloListDto> trelloListDtoList = new ArrayList<>();
        trelloListDtoList.add(trelloListDto1);

        TrelloList trelloList = new TrelloList();
        trelloList.setId("1");
        trelloList.setName("Test");
        trelloList.setClosed(true);

        List<TrelloList> testList = new ArrayList<>();
        testList.add(trelloList);

        //When
        List<TrelloList> trelloLists = trelloMapper.mapToList(trelloListDtoList);

        //Then
        assertEquals(trelloLists, testList);
    }

    @Test
    void mapToListDto() {
        //Give
        TrelloList trelloList = new TrelloList();
        trelloList.setId("1");
        trelloList.setName("Test");
        trelloList.setClosed(true);

        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(trelloList);


        TrelloListDto trelloListDto1 = new TrelloListDto();
        trelloListDto1.setId("1");
        trelloListDto1.setName("Test");
        trelloListDto1.setClosed(true);

        List<TrelloListDto> testList = new ArrayList<>();
        testList.add(trelloListDto1);

        //When
        List<TrelloListDto> trelloListDtoList = trelloMapper.mapToListDto(trelloLists);

        //Then
        assertEquals(trelloListDtoList, testList);
    }

    @Test
    void mapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("Test Name", "Test Description", "Test Pos","Test ListId");
        TrelloCardDto testData = new TrelloCardDto("Test Name","Test Description","Test Pos","Test ListId");

        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        //Then
        assertEquals(trelloCardDto, testData);
    }

    @Test
    void mapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("Test Name","Test Description","Test Pos","Test ListId");
        TrelloCard testData = new TrelloCard("Test Name", "Test Description", "Test Pos","Test ListId");

        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);

        //Then
        assertEquals(trelloCard.getName(), testData.getName());
        assertEquals(trelloCard.getDescription(), testData.getDescription());
        assertEquals(trelloCard.getPos(), testData.getPos());
        assertEquals(trelloCard.getListId(), testData.getListId());
    }
}
