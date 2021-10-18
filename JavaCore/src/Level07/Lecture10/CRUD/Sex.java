package Level07.Lecture10.CRUD;

public enum Sex {
    MALE("м"),
    FEMALE("ж");

    String textRU;

    public String getCommand() {
        return textRU;
    }

    Sex(String textRU) {
        this.textRU=textRU;
    }


}
