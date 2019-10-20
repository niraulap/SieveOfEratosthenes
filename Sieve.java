/** Sieve -- a filter for multiples of a specified number 
 
    @author  Prajita Niraula
    Grinnell College
    niraulap@grinnell.edu   

    An object of the Sieve class filters out the multiples of some specified number. 
*/
public class Sieve {
    
	/* The factor field stores the number whose multiple an object of Sieve is trying to block. */ 
    private int factor;
    /* The source field stores the previous Sieve object  that led to current Sieve object; thus, the source field references another sieve object inside the current one. */
    private Sieve source;

      /* The next method returns an integer that is not divisible by the factor. 

    @return  integer that is guaranteed not to be divisible by the current factor of the object Sieve 
    */ 
    public int next() {
        if (this.source != null) {
            int candidate = this.factor + 1;
            boolean found = true;
                    for(int i = 2; i < candidate; i ++) {
                    if(candidate % i == 0) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    return candidate;
                }//if  
                else {
                    ++this.factor;
                   return next();
                }//else
        }//if 
        else {
            return ++this.factor;
        }//else 
    }//next

    /*Overloading constructor */ 
      
    /* The Sieve constructor allocates storage for a new Sieve,
    initializes its current factor to parameter for factor given by the calling method and source to parameter for source given by the calling method and returns it. 
	*/
    public Sieve(int givenFactor, Sieve givenSource) {
        factor = givenFactor;
        source = givenSource;
    }//ConstructorWithTwoArguments  

    /* The Sieve constructor allocates storage for a new Sieve,
    increments its current factor and initializes the source to  null and returns it*/
   public Sieve() {
        this.factor++;
        source = null;
    }//baseConstructor  

 /** The main method creates objects of Sieve to print the first 500 prime numbers 

        @param  args which is ignored in this case 
    */
    public static void main(String[] args) {
        Sieve sifter = new Sieve();
        int prime = sifter.next();
        Sieve nextSourceSieve = sifter;
        for (int i = 0; i < 500; i++) {
            if (i % 10 == 0) {
                System.out.print("\n");
            }
            System.out.printf( "%7d ", prime);
            prime = nextSourceSieve.next();
            Sieve mySieve = new Sieve(prime, nextSourceSieve);
            nextSourceSieve = mySieve;
        }//for
    }//main

}//Class Sieve 


/*Help Recieved: 
 * Prof. Hajiamini in order to understand the underlying concept; especially for the method next as well as the order of printing the output. 
 * Class Mentor Xinya Yang in order to understand the concept for implementation of next method */ 