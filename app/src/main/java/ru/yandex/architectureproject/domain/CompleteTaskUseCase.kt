package ru.yandex.architectureproject.domain

import kotlinx.coroutines.delay
import ru.yandex.architectureproject.Constants.AUTO_DELETE_DELAY_MS
import ru.yandex.architectureproject.data.repository.TaskRepository

class CompleteTaskUseCase(
    private val repository: TaskRepository,
) {
    suspend operator fun invoke(taskId: Int) {
        repository.completeTask(taskId)
        delay(AUTO_DELETE_DELAY_MS)
        repository.deleteTask(taskId)
    }
}