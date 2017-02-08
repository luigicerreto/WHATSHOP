package com.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AddCatTest.class, AddNegTest.class, AddProdTest.class, AggiungiCarrelloTest.class, LoginTest.class,
		PagamentoTest.class, RegisterTest.class })
public class AllTests {

}
