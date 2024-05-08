# WhoAmIGame
# Guess The Character Game

This Java application is a simple interactive game where players guess the correct character based on given attributes. The game utilizes Swing for the GUI and includes elements of user interaction, character properties matching, and basic game flow management.

## How It Works

The game presents the user with a series of characters and questions about their attributes. Users can guess which character fits the description by clicking on character images, which reveals their attributes and determines if the guess is correct.

## Classes

### `BaslangicEkranı`

This class is responsible for displaying the initial screen of the application. It includes:

- **Image Display:** Displays an image as the background.
- **Start Button:** A button that when clicked, transitions from the start screen to the game screen (`OyunEkrani`).

### `KarakterSorulari`

This class acts as a small database to store character traits associated with each character and allows querying these traits:

- **Character Traits Setup:** Sets up a hashmap containing predefined questions and boolean values as answers for each character.
- **Question Answering:** Provides a method to answer questions about character attributes.

### `OyunEkrani`

This class handles the main game interface:

- **Character Display:** Displays character images.
- **Flip Effect:** Allows the player to click on character images to flip them and reveal their attributes.
- **Question Interaction:** Players can click on buttons to ask questions about the selected character.
- **Game Reset:** Includes functionality to restart the game with new characters and shuffled questions.

## Setup and Execution

To run this application:

1. Ensure Java is installed on your machine.
2. Compile the Java files using `javac` or any Java IDE (e.g., Eclipse, IntelliJ).
3. Run `BaslangicEkranı` to start the game.

## Dependencies

This project uses Java Swing for the GUI components and requires Java JDK 8 or later for optimal performance.

## Future Enhancements

- Improved UI aesthetics.
- Expansion of character database and traits.
- Implementation of difficulty levels and score tracking.

Thank you for exploring the Guess The Character Game. Enjoy playing and guessing!

