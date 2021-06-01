package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test

class StatisticsUtilsTest {

    // If there's no completed task and one active task,
    // then there are 100% percent active tasks and 0% completed tasks.

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {
        // GIVEN a list of tasks with a single, active task
        val tasks = listOf<Task>(
            Task("title", "description", isCompleted = false)
        )

        // WHEN you call getActiveAndCompletedStats
        val result = getActiveAndCompletedStats(tasks)

        // THEN there are 100% active tasks and 0% completed tasks
        assertThat(result.activeTasksPercent, `is`(100f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }

    // If there's no completed task and one active task,
    // then there are 100% percent active tasks and 0% completed tasks.

    @Test
    fun getActiveAndCompletedStats_noActive_returnsHundredZero() {
        // GIVEN a list of tasks with a single, completed task
        val tasks = listOf<Task>(
            Task("title", "description", isCompleted = true)
        )

        // WHEN you call getActiveAndCompletedStats
        val result = getActiveAndCompletedStats(tasks)

        // THEN there are 0% active tasks and 100% completed tasks
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(100f))
    }

    // If there's 3 completed tasks and 2 active tasks,
    // then there are 40% percent active tasks and 60% completed tasks.
    
    @Test
    fun getActiveAndCompletedStats_both_returnsFortySixty() {
        // GIVEN 3 completed tasks and 2 active tasks
        val tasks = listOf<Task>(
            Task("title", "description", isCompleted = true),
            Task("title", "description", isCompleted = true),
            Task("title", "description", isCompleted = true),
            Task("title", "description", isCompleted = false),
            Task("title", "description", isCompleted = false)
        )

        // WHEN you call getActiveAndCompletedStats
        val result = getActiveAndCompletedStats(tasks)

        // THEN the result is 40%-60%
        assertThat(result.activeTasksPercent, `is`(40f))
        assertThat(result.completedTasksPercent, `is`(60f))
    }

    // If there's a empty list of tasks,
    // then active tasks and completed tasks are set to 0%.

    @Test
    fun getActiveAndCompletedStats_empty_returnsZeros() {
        // GIVEN a empty list of tasks
        val tasks = emptyList<Task>()

        // WHEN you call getActiveAndCompletedStats
        val result = getActiveAndCompletedStats(tasks)

        // THEN the result is 0%-0%
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }

    // If a given list of tasks is null,
    // then active tasks and completed tasks are set to 0%.

    @Test
    fun getActiveAndCompletedStats_error_returnsZeros() {
        // GIVEN a list of tasks set to null
        val tasks = null

        // WHEN you call getActiveAndCompletedStats
        val result = getActiveAndCompletedStats(tasks)

        // THEN the result is 0%-0%
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }
}