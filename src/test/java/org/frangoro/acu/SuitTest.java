package org.frangoro.acu;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(Suite.class)
@Suite.SuiteClasses({MemberTest.class, CategoryTest.class})
public class SuitTest {
	
	final Logger logger = LoggerFactory.getLogger(SuitTest.class);
	
}
