# Random Book Quotes App

This Java application reads popular book quotes from a JSON file and displays a random quote along with its author. It uses the GSON library for JSON parsing.

## Installation

1. Clone this repository to your local machine using the following command:
   git clone <repository_url>
   cd quotes

2. Ensure you have Java and Gradle installed on your machine.

## Usage

1. Make sure you are in the `quotes` directory.

2. Run the application using the following command:
   gradle run

3. The app will display a randomly selected book quote and its author.

## Testing

To run the tests, execute the following command:
    gradle test


## Stretch Goals

### Search by Author

To search for a quote by a specific author, use the following command:
    gradle run --args "author AuthorName"

Replace `AuthorName` with the desired author's name.

### Search by Word

To search for a quote containing a specific word, use the following command:
    gradle run --args "contains Word"

Replace `Word` with the desired word.

You can also combine both search options:
    gradle run --args "author AuthorName contains Word"

