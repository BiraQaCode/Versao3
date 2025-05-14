package br.sp.UbiraProject.Suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.sp.UbiraProject.tests.ContaTest;
import br.sp.UbiraProject.tests.MovimentacaoTest;
import br.sp.UbiraProject.tests.RemoverMovimentacaoContaTest;
import br.sp.UbiraProject.tests.ResumoTest;
import br.sp.UbiraProject.tests.SaldoTeste;

@RunWith(Suite.class)
@SuiteClasses({
	ContaTest.class,
	MovimentacaoTest.class,
	RemoverMovimentacaoContaTest.class,
	SaldoTeste.class,
	ResumoTest.class,
}
		
		)


public class SuiteTest {

	
	
}
