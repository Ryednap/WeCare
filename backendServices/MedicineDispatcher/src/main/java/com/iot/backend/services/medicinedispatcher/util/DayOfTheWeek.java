package com.iot.backend.services.medicinedispatcher.util;

public enum DayOfTheWeek {
    SUN("Sunday"), MON("Monday"), TUE("Tuesday"),
    WED("Wednesday"), THU("Thursday"), FRI("Friday"),
    SAT("Saturday");

    private String label;
    private DayOfTheWeek(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "DayOfTheWeek{" +
                "label='" + label + '\'' +
                '}';
    }
}
