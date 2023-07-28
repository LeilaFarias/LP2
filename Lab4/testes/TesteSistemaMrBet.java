import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pack.Time;
import pack.Campeonato;
import pack.SistemaMrBet;

class TesteSistemaMrBet {
	
	private SistemaMrBet sistemaMrBet;
	
	@BeforeEach
	void preparaSistema() {
		this.sistemaMrBet = new SistemaMrBet();
		sistemaMrBet.cadastrarTime("250_PB", "Nacional de Patos", "Canário");
		sistemaMrBet.cadastrarTime("252_PB", "Sport Lagoa Seca", "Carneiro");
		sistemaMrBet.cadastrarTime("002_RJ", "Clube de Regatas do Flamengo", "Urubu");
		sistemaMrBet.cadastrarTime("105_PB", "Sociedade Recreativa de Monteiro (SOCREMO)", "Gavião");
	}

	@Test
	void testCadastrarTimeExistente() {
		String t1 = this.sistemaMrBet.cadastrarTime("250_PB", "Nacional", "Canário");
		assertEquals("TIME JÁ EXISTE!", t1);
		String t2 = this.sistemaMrBet.cadastrarTime("250_PB", "Palmeira", "Pavão");
		assertEquals("TIME JÁ EXISTE!", t2);
	}
	@Test 
	void testCadastrarTimeExceções() {
		try {
			this.sistemaMrBet.cadastrarTime(null, null, null);
			fail("era esperado uma exceção aqui");
		} catch (IllegalArgumentException iae) {
		}
		try {
			this.sistemaMrBet.cadastrarTime("", "", "");
			fail("era esperado uma exceção aqui");
		} catch (IllegalArgumentException iae1) {
		}
	}
	@Test
	void testCadastrarCampeonato() {
		String t1 = sistemaMrBet.cadastrarCampeonato("Brasileirão série A 2023", 5);
		assertEquals("CAMPEONATO ADICIONADO!", t1);
		String t2 = sistemaMrBet.cadastrarCampeonato("Brasileirão série A 2023", 3);
		assertEquals("CAMPEONATO JÁ EXISTE!", t2);
		String t3 = this.sistemaMrBet.cadastrarCampeonato("BRASILEIRÃO SÉRIE A 2023", 4);
		assertEquals("CAMPEONATO JÁ EXISTE!", t3);
		String t4 = this.sistemaMrBet.cadastrarCampeonato("brasileirão série a 2023", 4);
		assertEquals("CAMPEONATO JÁ EXISTE!", t4);
	}
	@Test 
	void testCadastrarCampeonatoExceções() {
		try {
			this.sistemaMrBet.cadastrarCampeonato(null, 0);
			fail("era esperado uma exceção aqui");
		} catch (IllegalArgumentException iae) {
		}
		try {
			this.sistemaMrBet.cadastrarCampeonato("", 0);
			fail("era esperado uma exceção aqui");
		} catch (IllegalArgumentException iae1) {
		}
	}
	@Test 
	void testRecuperarTime() {
		String t1 = sistemaMrBet.recuperarTime("250_PB");
		assertEquals("[250_PB] Nacional de Patos / Canário", t1);
		String t2 = this.sistemaMrBet.recuperarTime("258_RJ");
		assertEquals("TIME NÃO EXISTE!", t2);
	}
	@Test
	void testIncluirTimeCampeonato() {
		sistemaMrBet.cadastrarCampeonato("Brasileirão série A 2023", 5);
		
		String t1 = this.sistemaMrBet.incluirTimeCamp("250_PB", "Brasileirão série A 2023");
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!", t1);
		String t2 = this.sistemaMrBet.incluirTimeCamp("252_PB", "Brasileirão série A 2023");
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!", t2);
		String t3 = this.sistemaMrBet.incluirTimeCamp("252_PB", "Brasileirão série A 2023");
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!", t3);
	}
	@Test
	void testIncluirTimeCampeonatoFluxoAlternativo() {
		sistemaMrBet.cadastrarCampeonato("Brasileirão série A 2023", 5);
		
		String t1 = this.sistemaMrBet.incluirTimeCamp("005_PB", "Brasileirão série A 2023");
		assertEquals("TIME NÃO EXISTE!", t1);
		String t2 = this.sistemaMrBet.incluirTimeCamp("252_PB", "Brasileirão série D 2023");
		assertEquals("CAMPEONATO NÃO EXISTE!", t2);
	}
	@Test
	void testIncluirTimeCampeonatoExcedendoQntParticipantes() {
		sistemaMrBet.cadastrarCampeonato("Brasileirão série A 2023", 1);
		
		String t1 = this.sistemaMrBet.incluirTimeCamp("252_PB", "Brasileirão série A 2023");
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!", t1);
		String t2 = this.sistemaMrBet.incluirTimeCamp("250_PB", "Brasileirão série A 2023");
		assertEquals("TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!", t2);
	}
	@Test
	void testVerificarTimeEmCampeonato() {
		this.sistemaMrBet.cadastrarCampeonato("Copa do Nordeste 2023", 10);
		this.sistemaMrBet.incluirTimeCamp("250_PB", "Copa do Nordeste 2023");
		
		String t0 = this.sistemaMrBet.verificarTimeEmCamp("007_PB", "Copa do Nordeste 2023");
		assertEquals("TIME NÃO EXISTE!", t0);
		String t1 = this.sistemaMrBet.verificarTimeEmCamp("250_PB", "Copa do Nordeste 2023");
		assertEquals("O TIME ESTÁ EM CAMPEONATO!", t1);
		String t2 = this.sistemaMrBet.verificarTimeEmCamp("252_PB", "Copa do Nordeste 2023");
		assertEquals("O TIME NÃO ESTÁ EM CAMPEONATO!", t2);
	}
	@Test
	void testVerificarTimeEmCampeonatoFluxoAlternativo() {
		this.sistemaMrBet.cadastrarCampeonato("Copa do Nordeste 2023", 10);
		
		String t1 = this.sistemaMrBet.verificarTimeEmCamp("252_PB", "Brasileirão série D 2023");
		assertEquals("CAMPEONATO NÃO EXISTE!", t1);
		String t2 = this.sistemaMrBet.incluirTimeCamp("005_PB", "Copa do Nordeste 2023");
		assertEquals("TIME NÃO EXISTE!", t2);
	}
	@Test
	void testExibeCampeonatosTime() {
		this.sistemaMrBet.cadastrarCampeonato("Copa do Nordeste 2023", 10);
		this.sistemaMrBet.cadastrarCampeonato("Brasileirão série A 2023", 1);
		this.sistemaMrBet.cadastrarCampeonato("Brasileirão série D 2023", 2);
		this.sistemaMrBet.incluirTimeCamp("250_PB", "Copa do Nordeste 2023");
		this.sistemaMrBet.incluirTimeCamp("250_PB", "Brasileirão série A 2023");
		
		String t0 = this.sistemaMrBet.exibeCampeonatosTime("007_PB");
		assertEquals("TIME NÃO EXISTE!", t0);
		String t1 = this.sistemaMrBet.exibeCampeonatosTime("250_PB");
		assertEquals("Campeonatos do Nacional de Patos:\n"
				+ "Brasileirão série A 2023 - 1/1\n"
				+ "Copa do Nordeste 2023 - 1/10\n"
				+ "", t1);
	} 
	@Test
	void testApostar() {
		this.sistemaMrBet.cadastrarCampeonato("Copa do Nordeste 2023", 10);
		
		String t1 = this.sistemaMrBet.apostar("250_PB", "Copa do Nordeste 2023", 3, 10.50);
		assertEquals("APOSTA REGISTRADA!", t1);
		String t2 = this.sistemaMrBet.apostar("252_PB", "Copa do Nordeste 2023", 8, 90);
		assertEquals("APOSTA REGISTRADA!", t2);
	}
	@Test 
	void testApostarFluxoAlternativo() {
		this.sistemaMrBet.cadastrarCampeonato("Copa do Nordeste 2023", 10);
		
		String t1 = this.sistemaMrBet.apostar("005_RJ", "Copa do Nordeste 2023", 4, 100);
		assertEquals("TIME NÃO EXISTE!", t1);
		String t2 = this.sistemaMrBet.apostar("252_PB", "Brasileirão série D 2023", 7, 80);
		assertEquals("CAMPEONATO NÃO EXISTE!", t2);
		String t3 = this.sistemaMrBet.apostar("250_PB", "Copa do Nordeste 2023", 17, 10.57);
		assertEquals("APOSTA NÃO REGISTRADA!", t3);
	}
	@Test
	void testStatusApostas() {
		String t0 = this.sistemaMrBet.statusApostas();
		assertEquals("NÃO HÁ APOSTAS CADASTRADAS!", t0);
		this.sistemaMrBet.cadastrarCampeonato("Copa do Nordeste 2023", 10);
		String t1 = this.sistemaMrBet.apostar("250_PB", "Copa do Nordeste 2023", 3, 10.50);
		assertEquals("APOSTA REGISTRADA!", t1);
		String t2 = this.sistemaMrBet.statusApostas();
		assertEquals("1. [250_PB] Nacional de Patos / Canário\n"
				+ "Copa do Nordeste 2023\n"
				+ "3/10\n"
				+ "R$ 10.5\n"
				+ "\n"
				+ "", t2);
	}
}

