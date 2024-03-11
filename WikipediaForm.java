import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;

public class WikipediaForm extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Animal Details");

        // Sample Article (Replace this with your logic to fetch the article)
        String sampleTitle = "Animal Kingdom: A Diverse Tapestry of Life";
        String sampleDescription = "The animal kingdom is a vast and diverse group of organisms, constituting a major part of Earth's biodiversity. Animals are eukaryotic, multicellular organisms that exhibit a wide range of behaviors, morphologies, and adaptations to their environments. From the microscopic to the massive, animals inhabit virtually every corner of the globe, thriving in diverse ecosystems, from the depths of the oceans to the highest mountains.\n" +
                "\n" +
                "## Classification and Diversity\n" +
                "The classification of animals is organized into various phyla, each representing a distinctive set of characteristics. The phylum Chordata, for example, includes vertebrates like mammals, birds, reptiles, amphibians, and fish, characterized by the presence of a notochord at some stage of their development. Arthropoda, the largest phylum, comprises insects, arachnids, crustaceans, and myriapods, known for their segmented bodies and exoskeletons.\n" +
                "\n" +
                "Beyond these, there are numerous other phyla, such as Mollusca (snails, clams, octopuses), Annelida (earthworms, leeches), and Cnidaria (jellyfish, corals), each with its unique traits and adaptations.\n" +
                "\n" +
                "## Adaptations and Behaviors\n" +
                "Animals have evolved a myriad of adaptations that enable them to survive and thrive in their respective habitats. From the swift flight of birds to the intricate camouflaging abilities of chameleons, the animal kingdom showcases an incredible array of evolutionary solutions to life's challenges.\n" +
                "\n" +
                "Behaviors also play a crucial role in the animal kingdom. From the complex social structures of elephants and dolphins to the intricate web-building of spiders and the migration patterns of wildebeests, animals exhibit a wide range of behaviors that contribute to their survival and reproduction.\n" +
                "\n" +
                "## Ecological Roles\n" +
                "Animals play crucial roles in ecosystems as predators, prey, pollinators, seed dispersers, and ecosystem engineers. Biodiversity, the variety of life on Earth, is intricately linked to the health and functioning of ecosystems, and animals contribute significantly to this diversity.\n" +
                "\n" +
                "## Conservation Challenges\n" +
                "Despite their resilience and adaptability, many animal species face increasing threats due to human activities, such as habitat destruction, pollution, climate change, and over-exploitation. Conservation efforts are essential to protect and preserve the rich tapestry of life within the animal kingdom.\n" +
                "\n" +
                "In conclusion, animals represent a spectacular tapestry of life on Earth, showcasing the wonders of evolution, adaptation, and interconnectedness in the natural world. Studying and appreciating the diverse array of animals is not only a scientific pursuit but also an exploration of the intricate and fascinating web of life that surrounds us.";

        // Create Labels
        Label titleLabel = new Label(sampleTitle);
        Label descriptionLabel = new Label(sampleDescription);

        // Set fonts, colors, and sizes
        titleLabel.setFont(new Font("Arial", 24));
        titleLabel.setTextFill(Color.DARKBLUE);

        descriptionLabel.setFont(new Font("Calibri", 16));
        descriptionLabel.setTextFill(Color.BLACK);

        // Set specific width for descriptionLabel
        descriptionLabel.setWrapText(true);

        // Create VBox to hold labels
        VBox labelsVBox = new VBox(10);
        labelsVBox.getChildren().addAll(titleLabel, descriptionLabel);

        // Use ScrollPane to allow scrolling through labels
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(labelsVBox);
        scrollPane.setFitToWidth(true);

        // Make the border invisible
        scrollPane.setStyle("-fx-background-color: transparent;");

        // Layout
        VBox mainVBox = new VBox(10); // Vertical box with spacing
        mainVBox.setPadding(new Insets(20, 20, 20, 20)); // Padding for better appearance
        mainVBox.getChildren().add(scrollPane);

        // Set window size and center on screen
        primaryStage.setHeight(450);
        primaryStage.setWidth(800);
        primaryStage.centerOnScreen();

        // Show the scene
        Scene scene = new Scene(mainVBox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

