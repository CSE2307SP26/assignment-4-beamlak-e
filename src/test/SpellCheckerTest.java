package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SpellCheckerTest {

    /// class Test (decided to rename)
	//@Test
	///void test() {
	///	SpellChecker spellChecker = new SpellChecker(); ///creates obj to be tested
	///	int words = spellCheck.getNumberOfWords(); ////calls method being tested 
	///	assertEquals(0, words);  ////using assertions to validate 
	///}
    
	///spellChecker
	//Test for spellChecker to return the amount of word it knows 
	@Test 
	void initialWordCountIncrease(){
		SpellChecker spellChecker = new SpellChecker(); 
		assertEquals(0,spellChecker.getWordCount(), "Inital value should be 0"); 	
	}

    //// Second test for number of words spell checker knows to increment
	@Test 
	void TestAddWordIncWordCount(){
		SpellChecker spellChecker = new SpellChecker(); 
	    spellChecker.addWord("hello"); 
		assertEquals(1, spellChecker.getWordCount()); 
	}
	
	////Xheck if the word is already contained in the SpellChecker spellChecker count should not change  
	 @Test 
	 void TestAddingDuplicateWordDoesNotIncreaseCount(){
		SpellChecker spellChecker = new SpellChecker(); 
		spellChecker.addWord("Bye");    
		spellChecker.addWord("Bye"); 
		 assertEquals(1, spellChecker.getWordCount()); 
		 //// only increments 1, second one is not recongized 
	 }

    //// Accept properly spelled word returns words that are incorrectly spelled (For true cases)
	@Test 
	 void TestCheckIfProperlySpelled(){
		SpellChecker spellChecker = new SpellChecker(); 
		spellChecker.addWord("Hello"); 
		/// asserts true if word is correctly spelled 
		assertTrue(spellChecker.checkWord("Hello"), "Word should be Identified as correctly spelled"); 
		assertEquals(1, spellChecker.getWordCount());
	 }
  
	 ///Checks impropper spelling
	 @Test 
	 void TestCheckIfMisspelled(){
		SpellChecker spellChecker = new SpellChecker(); 
		spellChecker.addWord("happy"); 
		assertFalse(spellChecker.checkWord("hppy"), "Word should be Identified as incorrectly spelled"); 

	 }

      ////  Recommending test cases 
	  @Test 
	    void testSuggestWord(){ 
			SpellChecker spellChecker = new SpellChecker(); 
			spellChecker.addWord("bamk");
			assertEquals("bank", spellChecker.suggestWord("bamk")); 
			assertEquals(1, spellChecker.getWordCount()); 
		}
      
		/// Recommending test case for a word thats already correctly spelled  
		@Test 
		 void testSuggestWordForCorrectlySpelled(){ 
			SpellChecker spellChecker = new SpellChecker(); 
			spellChecker.addWord("mine"); 
			assertEquals("mine", spellChecker.suggestWord("mine")); 
			assertEquals(1, spellChecker.getWordCount()); 
		}

	   //// ignoring test case for a how a word is spelled cat = Cat = CAt  
	   @Test 
	     void testCaseIgnoreCase(){
			SpellChecker spellChecker = new SpellChecker(); 
			spellChecker.addWord("cat"); 
			assertTrue(spellChecker.checkWord("Cat"), "Word should be identified as spelled correctly"); 
			assertTrue(spellChecker.checkWord("caT"), "Word should be identified as spelled correctly"); 
			assertEquals(1, spellChecker.getWordCount());	
		 }

       //// Test case for adding special word to SpellChecker
	   @Test 
	   void testAddingSpecialWord(){
		    SpellChecker spellChecker = new SpellChecker(); 
			spellChecker.addWord("c@t"); 
			assertTrue(spellChecker.checkWord("c@t"), "Word should be identified as spelled correctly"); 
			assertEquals(1,spellChecker.getWordCount());
	   }

	   //// Test case for empty string 
	   @Test
	   void testAddingEmptyString(){
		    SpellChecker spellChecker = new SpellChecker(); 
			spellChecker.addWord(""); 
			assertFalse(spellChecker.checkWord(""), "empty String should be identified as incorrect"); 
			assertEquals(0, spellChecker.getWordCount());
	   }
}
