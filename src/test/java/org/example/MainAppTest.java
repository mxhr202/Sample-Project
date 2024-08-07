package org.example;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.testfx.assertions.api.Assertions.assertThat;

public class MainAppTest extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        new MainApp().start(stage);
    }

    @Test
    public void testLoginOpensMainWindow() {
        // Simulate clicking the login button
        clickOn("#loginButton");

        // Ensure the main window contains a label with the expected text
        Label label = lookup("#myLabelId").query();
        assertThat(label).isNotNull();
        assertThat(label.getText()).isEqualTo("welcome to Main Window!");
    }

    @Test
    public void testOpenSecondWindow() {
        // Click the "Zum zweiten Fenster" button
        clickOn("#openSecondWindowButton");

        // Verify that the second window is opened
        // Switch to the second window
        window("Second Window");

        // Lookup for the label in the second window
        String labelText = lookup(".label").tryQueryAs(Label.class)
                .map(Label::getText)
                .orElse("");

        // Assert that the label's text is what we expect
        assertTrue(labelText.equals("welcome to second window!"),
                "Second window should contain the expected text");

        // Click the "Zurück zum Hauptfenster" button
        clickOn("#backButton");

        // Verify that the main window is opened again
        window("Main Window");
    }
}
