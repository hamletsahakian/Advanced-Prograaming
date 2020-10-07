package assignment1;

public interface SetInterface {
    /*
    * @Elements: Object of the type Identifier
    * @Structure: None
    * @Domain: All elements must be unique, contains [0-MAX_NUMBER_OF_ELEMENTS] identifiers
    *
    * constructors
    *
    * Set();
    *   @precondition  -
    *   @postcondition - A new Set-object that contains the empty set
    *
    * Set (Set src);
    *   @precondition  -
    *   @postcondition - A new Set-object that contains a copy of src
    */

    int MAX_NUMBER_OF_ELEMENTS = 20;


    void init();
    /*  @precondition -
        @postcondition - The set is empty
     */

    
     void add(Identifier e);
    /*  @precondition -
        @postcondition - 
                success: element is in the set
                failure: element already present in set-@precondition or set size exceeds MAX_NUMBER_OF_ELEMENTS
     */

     String toString();
     /*  @precondition - set is not empty
         @postcondition - set as string has been returned 
    */            
                
                
    Identifier get();
    /*  @precondition -  set is not empty
        @postcondition - An element from the set has been returned.
               
     */

    boolean contains(Identifier e);
    /*  @precondition -
        @postcondition -  success: The set contains the identifier passed as parameter
                		  failure: The set does not contain identifier passed as parameter
     */

    int size();
    /*  @precondition -
        @postcondition - the number of elements in the set has been returned
     */

    boolean equals(Set s);
    /*  @precondition -
        @postcondition -  success: parameter set and this set are the same size and contain the same elements
                		  failure: parameter set and this set are not the same size or do not contain the same elements
     */

   
    Set union(Set s) throws Exception ;
    /*  @precondition -
        @postcondition - A set contaning all disctinct identifiers from the parameter set and this has been returned
        	   success: union of two sets is returned
        	   failure: throws when amount of elements exceeds MAX_NUMBER_OF_ELEMENTS
     */

    Set difference(Set s);
    /*  @precondition -
        @postcondition - A set containing the identifiers that are absent in the parameter set but present in this has been returned
        				
     */

    Set intersection(Set s);
    /*  @precondition -
        @postcondition - A set containing the identifiers that are both present in the parameter set and this has been returned
        
     */					

    Set symDifference(Set s) throws Exception; 
    /*  @precondition -
        @postcondition - A set containing the identifiers which are absent in the parameter set and present in this and identifiers that are present in the present paremeter set but absent in this has been returned
        	   success: symmetric difference of two set is returned
        	   failure: amount of elements exceeds MAX_NUMBER_OF_ELEMENTS
     */
}