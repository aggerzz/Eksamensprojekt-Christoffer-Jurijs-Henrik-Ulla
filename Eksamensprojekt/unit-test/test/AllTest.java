package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ TestKunde.class, TestSælger.class, TestBil.class, TestAKIAccess.class, TestBankAccess.class,
		TestLåneanmodning.class })

public class AllTest {
}
