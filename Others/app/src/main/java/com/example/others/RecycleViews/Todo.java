package com.example.others.RecycleViews;

public class Todo {
    private String taskNote;
    private boolean status;

    public Todo(String taskNote, boolean status) {
        this.taskNote = taskNote;
        this.status = status;
    }

    public String getTaskNote() {
        return taskNote;
    }

    public void setTaskNote(String taskNote) {
        this.taskNote = taskNote;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
