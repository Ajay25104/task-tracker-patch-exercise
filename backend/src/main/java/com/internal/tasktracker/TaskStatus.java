package com.internal.tasktracker;

public enum TaskStatus {
    OPEN,
    IN_PROGRESS,
    DONE;

    public static boolean isValid(String value) {
        if (value == null || value.isBlank()) {
            return false;
        }

        for (TaskStatus status : values()) {
            if (status.name().equalsIgnoreCase(value)) {
                return true;
            }
        }

        return false;
    }
}
