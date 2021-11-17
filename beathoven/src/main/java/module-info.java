module Beathoven {
    requires javafx.controls;
    requires javafx.fxml;
    requires jfugue;

    opens Beathoven to
            javafx.fxml;

    exports Beathoven;
}
