package com.mirzoev.demo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {
    private TableView<Film> filmTable;
    private ObservableList<Film> filmList;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Film Client");

        // Создание таблицы для отображения списка фильмов
        filmTable = new TableView<>();
        filmList = FXCollections.observableArrayList();

        TableColumn<Film, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Film, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Film, Genre> genreColumn = new TableColumn<>("Genre");
        genreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));

        TableColumn<Film, Integer> durationColumn = new TableColumn<>("Duration");
        durationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));

        TableColumn<Film, Integer> releaseYearColumn = new TableColumn<>("Release Year");
        releaseYearColumn.setCellValueFactory(new PropertyValueFactory<>("releaseYear"));

        filmTable.getColumns().addAll(idColumn, titleColumn, genreColumn, durationColumn, releaseYearColumn);
        filmTable.setItems(filmList);

        // Создание кнопок
        Button addButton = new Button("Add Film");
        addButton.setOnAction(event -> handleAddButton());

        Button deleteButton = new Button("Delete Film");
        deleteButton.setOnAction(event -> handleDeleteButton());

        Button editButton = new Button("Edit Film");
        editButton.setOnAction(event -> handleEditButton());

        // Создание панели с кнопками
        HBox buttonPanel = new HBox(10, addButton, deleteButton, editButton);

        // Создание корневого контейнера и добавление компонентов
        VBox root = new VBox(10, filmTable, buttonPanel);
        root.setPadding(new Insets(10));

        // Создание сцены и установка корневого контейнера
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);

        // Отображение главного окна приложения
        primaryStage.show();
    }

    private void handleAddButton() {
        // Обработчик нажатия кнопки "Add Film"
        // В этом методе можно вызвать соответствующий метод REST API сервера для добавления фильма
    }

    private void handleDeleteButton() {
        // Обработчик нажатия кнопки "Delete Film"
        // В этом методе можно вызвать соответствующий метод REST API сервера для удаления фильма
    }

    private void handleEditButton() {
        // Обработчик нажатия кнопки "Edit Film"
        // В этом методе можно вызвать соответствующий метод REST API сервера для редактирования информации о фильме
    }
}