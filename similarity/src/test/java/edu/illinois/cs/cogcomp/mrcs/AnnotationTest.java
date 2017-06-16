package edu.illinois.cs.cogcomp.mrcs;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import edu.illinois.cs.cogcomp.core.datastructures.ViewNames;
import edu.illinois.cs.cogcomp.core.datastructures.textannotation.Constituent;
import edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation;
import edu.illinois.cs.cogcomp.llm.common.PhraseList;
import edu.illinois.cs.cogcomp.llm.common.Preprocess;

public class AnnotationTest {
	
	@Test
	public void contPhraseTest(){
		PhraseList pl=new PhraseList("src/main/resources/phrases.txt");
		String s="please turn the television monitor on yo";
		String ret=new Preprocess().getPhrase(s, pl);
		System.out.println(ret);
		assertTrue(ret.equals("please turn_on the television_monitor yo"));
	}
	
	
	@Test
	public void discontPhraseTest(){
		PhraseList pl=new PhraseList("src/main/resources/phrases.txt");
		String s="please turn the light on";
		String ret=new Preprocess().getDiscontPhrase(s, pl);
		System.out.println(ret);
		assertTrue(ret.equals("please turn_on the light"));
	}
	
	@Ignore	
	@Test
	public void nerTest(){
		Preprocess p=new Preprocess();
		p.initializeNER();
		TextAnnotation ta = p.runNER("Donald Trump turn on the light");
		List<Constituent> ne = ta.getView(ViewNames.NER_CONLL).getConstituents();
		System.out.println(ne.toString());
		assertTrue(ne.equals("please turn_on the light"));
	}
}
