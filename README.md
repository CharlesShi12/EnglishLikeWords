## Gibberish Generator
An algorithm that generates random English-like words using a trained model and highly optimized data structures.

## General Technical Description 
The model used in this project was trained with over 80,000 words to produce accurate/pronounceable outputs. The models looks at the probabilities of letters happening after a letter has already occurred. For instance, "se" is more likely to happen compared to "sx".  The project also used a used a Trie data structure for efficiency in Java as Trie data structures are quite useful for storing short Strings in Java. 

## Demonstration
Video demonstration of this algorithm is linked here: https://youtu.be/2hZ3b-ourXA. 

## Tech/Framework used
Built with 
* Java

## Features
* Generates a certain amount of English-like words using probabilities

## Installations
Run this command in your terminal: 
```
git clone https://github.com/CharlesShi12/EnglishLikeWords.git
```
Import the folder as a project into your respective IDE and run the Index.java file. 

## License
MIT © Charles Shi

