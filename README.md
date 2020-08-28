## Gibberish Generator
An algorithm that generates random English-like words using trained models and highly optimized data structures.

## General Technical Description 
The models used in this project were trained with over 80,000 words to produce accurate/pronounceable outputs. The models looks at the probabilities of letters happening after a letter has already occurred (or conditional probability). For instance, if the letter "s" has occurred, "se" is more likely to happen compared to "sx". The project also used a used a Trie data structure for efficiency in Java as Trie data structures are quite useful for storing short Strings in Java. 

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
git clone https://github.com/CharlesShi12/GibberishGenerator.git
```
Import the folder as a project into your respective IDE and run the Index.java file. 

## License
MIT © Charles Shi

