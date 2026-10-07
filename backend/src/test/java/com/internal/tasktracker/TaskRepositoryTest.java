package com.internal.tasktracker;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void searchTasks_appliesStatusFilterToMatchingDescriptionResults() {
        List<Task> results = taskRepository.searchTasks("%api%", "OPEN");

        assertThat(results)
            .allMatch(task -> task.isArchived() == false)
            .allMatch(task -> task.getStatus().equals("OPEN"));
    }
}
