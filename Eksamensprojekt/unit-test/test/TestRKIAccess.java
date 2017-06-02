package test;

import static org.junit.Assert.*;

import org.junit.Test;

import access.RKIAccess;
import domain.Låneanmodninglmpl;
import exceptions.KreditværdighedIkkeUdfyldtException;

public class TestRKIAccess {

	@Test
	public void testGetKreditværdighedA() throws KreditværdighedIkkeUdfyldtException {
		
		Låneanmodninglmpl låneanmodning = new Låneanmodninglmpl();
		RKIAccess RKI = new RKIAccess(låneanmodning, "0000000000");
		
		
		Låneanmodninglmpl kreditværdighed = new Låneanmodninglmpl();
		kreditværdighed.setKreditværdighed('A');
		RKI.getKreditværdighed();
		assertEquals(kreditværdighed.getKreditværdighed(), låneanmodning.getKreditværdighed());	
	}
	
	@Test
	public void testGetKreditværdighedB() throws KreditværdighedIkkeUdfyldtException {
		
		Låneanmodninglmpl låneanmodning = new Låneanmodninglmpl();
		RKIAccess RKI = new RKIAccess(låneanmodning, "0000000001");
		
		
		Låneanmodninglmpl kreditværdighed = new Låneanmodninglmpl();
		kreditværdighed.setKreditværdighed('B');
		RKI.getKreditværdighed();
		assertEquals(kreditværdighed.getKreditværdighed(), låneanmodning.getKreditværdighed());	
	}
	
	@Test
	public void testGetKreditværdighedC() throws KreditværdighedIkkeUdfyldtException {
		
		Låneanmodninglmpl låneanmodning = new Låneanmodninglmpl();
		RKIAccess RKI = new RKIAccess(låneanmodning, "0000000002");
		
		
		Låneanmodninglmpl kreditværdighed = new Låneanmodninglmpl();
		kreditværdighed.setKreditværdighed('C');
		RKI.getKreditværdighed();
		assertEquals(kreditværdighed.getKreditværdighed(), låneanmodning.getKreditværdighed());	
	}
	
	@Test
	public void testGetKreditværdighedD() throws KreditværdighedIkkeUdfyldtException {
		
		Låneanmodninglmpl låneanmodning = new Låneanmodninglmpl();
		RKIAccess RKI = new RKIAccess(låneanmodning, "0000000003");
		
		
		Låneanmodninglmpl kreditværdighed = new Låneanmodninglmpl();
		kreditværdighed.setKreditværdighed('D');
		RKI.getKreditværdighed();
		assertEquals(kreditværdighed.getKreditværdighed(), låneanmodning.getKreditværdighed());	
	}
}