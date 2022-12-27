package observer;
import java.util.EmptyStackException;
import java.util.Stack;

/**
* This class is a new version of the StringBuilder class that allows undo operations.
* The functions here are being executed by using the StringBuilder functions.
* @author Maor Or. 
* @author Raz Saad.
*/

public class UndoableStringBuilder {

	/**
	*Class attributes:
	*sb - sb is a StringBuilder object.
	*sb1 - sb1 is a StringBuilder object that points at the previous iteration of sb and stores it at the undo stack.
	*undo - undo is a stack of StringBuilder objects that stores the previous changes of sb.
	*/
	StringBuilder sb;
	StringBuilder sb1;
	Stack <StringBuilder> undo;
	
	/**
	*  Empty constructor that called to the empty constructor of StringBuilder, initiates StringBuilder stack.
	*/
	public UndoableStringBuilder()
	{
		sb = new StringBuilder ();
		undo = new Stack <StringBuilder>();
	}

	/**
	*  Constructor that called to the constructor of StringBuilder with string value of str, initiates StringBuilder stack.
	*  @param str - the string value of the object that we create.
	*  @exception NullPointerException if the input str is null.
	*/
	public UndoableStringBuilder(String str)
	{
		try {
			sb = new StringBuilder (str);
			undo = new Stack <StringBuilder>();
		}
		catch(NullPointerException e)
		{
			System.err.println("Can't create object with null string" + e);
			e.printStackTrace();
		}
	}
	
	
	/**
	* Appends the specified string to this character sequence.
	  The characters of the String argument are appended, in order,
	  increasing the length of this sequence by the length of the argument. 
	  If str is null, then the four characters "null" are appended.
	* @param str - string to append
	* @return a reference to the updated UndoableStringBuilder object.  
	*/
	
	public UndoableStringBuilder append(String str)
	{
		sb1 = new StringBuilder(sb);
		undo.push(sb1);
		sb.append(str);
		return this;

	}

	/**
	* Removes the characters in a substring of this sequence. The substring begins 
	  at the specified start and extends to the character at index
	  end - 1 or to the end of the sequence if no such character exists. 
	  If start is equal to end, no changes are made.
	* @param start - The beginning index, inclusive.
	* @param end - The ending index, exclusive.
	* @return a reference to the updated UndoableStringBuilder object. 
	* @exception StringIndexOutOfBoundsException if start is negative, greater than length(), or greater than end.
	*/

	public UndoableStringBuilder delete(int start, int end) 
	{
		try
		{
			sb1 = new StringBuilder(sb);
			undo.push(sb1);
			sb.delete(start,end);
			return this;
		}
		catch(StringIndexOutOfBoundsException e)
		{
			System.err.println("Invalid parameters,can't perfom delete action" + e);
			e.printStackTrace();
		}
		return this;
	}

	/**
	* Inserts the string into this character sequence.
	  The characters of the String argument are inserted, in order, 
	  into this sequence at the indicated offset, moving up any characters originally above 
	  that position and increasing the length of this sequence by the length of the argument. 
	  If str is null, then the four characters "null" are inserted into this sequence.
	* @param offset - the offset
	* @param str - a string to insert
	* @return a reference to the updated UndoableStringBuilder object.
	* @exception StringIndexOutOfBoundsException if the offset is invalid.
	*/
	
	public UndoableStringBuilder insert(int offset, String str) 
	{
		try {
			sb1 = new StringBuilder(sb);
			undo.push(sb1);
			sb.insert(offset,str);
			return this;
		}
		catch(StringIndexOutOfBoundsException e)
		{
			System.err.println("Invalid parameters,can't perfom insert action" + e);
			e.printStackTrace();
		}
		return this;
	} 

	/**
	* Replaces the characters in a substring of this sequence with characters in the specified String.
      The substring begins at the specified start and extends to the character 
      at index end - 1 or to the end of the sequence if no such character exists. 
      First the characters in the substring are removed and then the specified String is inserted at start. 
	* @param start - The beginning index, inclusive.
	* @param end - The ending index, exclusive.
	* @param str - String that will replace previous contents.
	* @return a reference to the updated UndoableStringBuilder object. 
	* @exception StringIndexOutOfBoundsException if start is negative, greater than length(), or greater than end.
	* @exception NullPointerException if the input str is null. 
	*/
	
	public UndoableStringBuilder replace(int start,int end, String str)
	{
		try {
			sb1 = new StringBuilder(sb);
			undo.push(sb1);
			sb.replace(start,end,str);
			return this;
		}
		catch(StringIndexOutOfBoundsException e)
		{
			System.err.println("Invalid parameters,can't perfom replace action" + e);
			e.printStackTrace();
		}
		catch(NullPointerException e)
		{
			System.err.println("Invalid parameters,can't perfom replace action" + e);
			e.printStackTrace();
		}
		
		return this;
	}

	/**
	* Causes this character sequence to be replaced by the reverse of the sequence.
	  If there are any surrogate pairs included in the sequence, 
	  these are treated as single characters for the reverse operation.
	  Thus, the order of the high-low surrogates is never reversed.
	* @return a reference to the updated UndoableStringBuilder object.  
	*/
	
	public UndoableStringBuilder reverse() 
	{
		sb1 = new StringBuilder(sb);
		undo.push(sb1);
		sb.reverse();
		return this;
	}

	/**
	* Updates sb to be the last StringBuilder that was stored in the undo stack and removes it from the stack.
	* If the stack is empty the function will handle an exception.
	* @exception EmptyStackException if the stack is empty.
	*/
	
	public void undo()
	{
		try
		{
			sb=undo.pop();

		}
		catch (EmptyStackException e)
		{
			//System.err.println("No more undo " + e);
		}


	}

	public String toString()
	{
		try {
			return sb.toString();
		}
		catch(NullPointerException e)
		{
			System.err.println("Can't print null attributes " + e);
			e.printStackTrace();
		}
		return "";
	}

}

