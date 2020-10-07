package assignment1;

public interface IdentifierInterface {
    /*
    @Elements: characters of type char
    @Structure: Linear
    @Domain: alphanumeric characters that begin with a letter and have a length of at least 1
    
     constructors
        * Identifier(); 
    *   @precondition  - *
    *   @postcondition - A new Identifier that contains an undefined value
    *
    *  Identifier
    *   	@precondition  -  *
    *       @postcondition - A new Identifier-object that contains a copy of src
    *
    */

	
    void init(char c);
    /* @precondition  - char c is an alphanumeric character
       @postcondition - Identifier has one char, char c
     */

    void add(char c);
    /* @precondition  - char c is an alphanumeric character
       @postcondition - the char falls inside the domain and is added to set with length+1       		  
     */

    int size();
    /* @precondition  -
       @postcondition - the number of chars in the identifier has been returned
     */

    boolean equals(Identifier comparand);
    /* @precondition  -
       @postcondition - succes: The value of this identifier is equal to the value of the argument identifier
       		  			failure: The value of this identifier is not equal to the value of the argument identifier
     */
    
    String get();
    
    /* @precondition  - 
       @postcondition - identifier as string has been returned
     */
}