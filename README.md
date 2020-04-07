# ID Block Information

* @author Eric Zair
* @email zairea200@potsdam.edu

## Description

I will write a symbol (or "word") count program. The quotes indicate that the definition of "word" is not quite standard. A word is basically an integer, a sequence of letters and digits, or a punctuation symbol. The code will process a set of files listed on the command-line, reading each file, breaking it down into a series of words, and use `Map` to count the number of times each word occurs.

Note that This version of the word counter is comment aware, meaning that we will be completely ignoring anything in a Scheme comment.

### Scheme Comments

* Anything between `#|` and `|#` will be ignored.

* Anything after `;` will be ignored.

When run, `WordCounter` will check the command-line for arguments.

If there are no arguments, terminate with an appropriate error message.

 For each argument, treat it as a file name and open it for input.

 If the file cannot be opened for input, produce an appropriate error message and go to next parameter.

 If the file opens for input:

 Read the contents of the file, one "word" at a time:

 A "word" is:

* A sequence of decimal integers; begins with a digit, ends on first non-digit Example: 233
* A sequence of letters and integers; begins with a letter, ends on first character that is neither a letter nor a digit Example: mutant999
* A punctuation symbol; begins with the symbol, ends on next character Example: .

## How To Compile && run

### Building/Compiling the program

To build/compile the program, simply run the following command:

`gradle clean build`

This will build the program for you (assuming that you have gradle installed on your computer).

### Running the program

After building the program, simply run it by doing the following:

`gradle run --args <file_to_pass_in_to_program>`

Note that if you do not run this with the file name, you will receive the following message from the program:

```Ignore
Program must take a file as an argument.
Run without gradle: java WordCounter <path_to_file>
Run with gradle: gradle run --args <path_to_file>
```

### Build & Run all in one

Alternatively you can build and run the program in one step by doing the following:

`gradle clean build run --args <file_to_pass_in_to_program>`

## Testing

In order to test the program, I have build a few text files to test with. These test files are located in the root project directory `tests/` folder. `alligator_test_with_comments.txt`

Below I will show an example of the file content, then I will show the results my program reduces.

### File Content

```Ignore
# ##|all|#igator ;[11]
x37] 1.1.1

```

### Output of WordCounter.java

```Ignore
 > Task :run
Output for "tests/alligator_test_with_comments.txt":
# : 2
. : 2
1 : 3
] : 1
igator : 1
x37 : 1

BUILD SUCCESSFUL in 1s
7 actionable tasks: 7 executed
```

## Doxygen & Documentation

Comments in this program are done in a format that supports using doxygen to generate .html documentation.

### Generating Doxygen Documentation

To Generate doxygen documentation make sure that doxygen is properly installed on your system.

If it is not installed on your system and you are running linux, run the following command:

`sudo apt-get install doxygen`

This will install doxygen on your computer.

### The generate_open_docs.py script

To do a quickly generate and open documentation, simply run the command `./generate_open_docs.py` and the documentation will be built and then opened up in your web browser.

NOTE: If you already have a web browser open, then the documentation will open in that window.

Now that doxygen is installed on your computer, you can run the following command to generate the documentation:

`cd doc; doxygen Doxyfile`

Once executed, the documentation will be generated successfully.

To Easily view it, inside of the `doc/` folder look for `html/index.html` and open it.
