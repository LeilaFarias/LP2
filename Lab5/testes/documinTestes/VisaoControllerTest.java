package documinTestes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import documin.DocumentoController;
import documin.VisaoController;

class VisaoControllerTest {

	private DocumentoController docController;
	private VisaoController visController;

	@BeforeEach
	void setUp() throws Exception {
		this.docController = new DocumentoController();
		this.visController = new VisaoController(this.docController);
		docController.criarDocumento("lp2");
	}

	@Test
	void testCriarVisaoCompleta() {
		assertEquals(0, visController.criarVisaoCompleta("lp2"));
		assertEquals(1, visController.criarVisaoCompleta("lp2"));
	}
	@Test
	void testCriarVisaoCompletaExceptions() {
		try {
			visController.criarVisaoCompleta("");
		} catch (IllegalArgumentException iae) {}
		try {
			visController.criarVisaoCompleta("lp3");
		} catch (NoSuchElementException nsee) {}
	}
	@Test
	void testCriarVisaoResumida() {
		assertEquals(0, visController.criarVisaoResumida("lp2"));
		assertEquals(1, visController.criarVisaoResumida("lp2"));
	}
	@Test
	void testCriarVisaoResumidaExceptions() {
		try {
			visController.criarVisaoResumida("");
		} catch (IllegalArgumentException iae) {}
		try {
			visController.criarVisaoResumida("lp3");
		} catch (NoSuchElementException nsee) {}
	}
	@Test
	void testCriarVisaoPrioritaria() {
		assertEquals(0, visController.criarVisaoPrioritaria("lp2", 3));
		assertEquals(1, visController.criarVisaoPrioritaria("lp2", 4));
	}
	@Test
	void testCriarVisaoPrioritariaExceptions() {
		try {
			visController.criarVisaoPrioritaria("", 3);
		} catch (IllegalArgumentException iae) {}
		try {
			visController.criarVisaoPrioritaria("lp3", 3);
		} catch (NoSuchElementException nsee) {}
		try {
			visController.criarVisaoPrioritaria("lp2", -5);
		} catch (IllegalArgumentException iae) {}
		try {
			visController.criarVisaoPrioritaria("lp2", 8);
		} catch (IllegalArgumentException iae) {}
	}
	@Test
	void testCriarVisaoTitulo() {
		assertEquals(0, visController.criarVisaoTitulo("lp2"));
		assertEquals(1, visController.criarVisaoTitulo("lp2"));
	}
	@Test
	void testCriarVisaoTituloExceptions() {
		try {
			visController.criarVisaoTitulo("");
		} catch (IllegalArgumentException iae) {}
		try {
			visController.criarVisaoTitulo("lp3");
		} catch (NoSuchElementException nsee) {}
	}
	@Test
	void testExibirVisao() {
		docController.criarTexto("lp2", "Texto Interface", 4);
		docController.criarTexto("lp2", "Texto Java", 3);
		docController.criarTitulo("lp2", "Titulo", 1, 2, false);
		docController.criarLista("lp2", "Lista / Exemplo", 1, "/", "-");
		docController.criarTermo("lp2", "Termo / Exemplo", 2, "/", "alfabética");
		
		visController.criarVisaoCompleta("lp2");
		visController.criarVisaoPrioritaria("lp2", 2);
		visController.criarVisaoResumida("lp2");
		visController.criarVisaoTitulo("lp2");
		assertEquals("[Texto Interface, Texto Java, 2. Titulo, - Lista\n- Exemplo, "
				+ "Total termos: 2\n- Exemplo, Termo]", Arrays.toString(visController.exibirVisao("lp2", 0)));
		
		assertEquals("[Texto Interface, Texto Java, "
				+ "Total termos: 2\n- Exemplo, Termo]", Arrays.toString(visController.exibirVisao("lp2", 1)));
		
		assertEquals("[Texto Interface, Texto Java, "
				+ "2. Titulo, Lista / Exemplo, Exemplo / Termo]", Arrays.toString(visController.exibirVisao("lp2", 2)));
		
		docController.criarTitulo("lp2", "Titulo 2", 4, 3, false);
		assertEquals("[2. Titulo, 3. Titulo 2]", Arrays.toString(visController.exibirVisao("lp2", 3)));
	}
	@Test
	void testExibirVisaoExceptions() {
		try {
			visController.exibirVisao("", 0);
		} catch (IllegalArgumentException iae) {}
		try {
			visController.exibirVisao("lp3", 0);
		} catch (NoSuchElementException nsee) {}
		try {
			visController.exibirVisao("lp2", 0);
		} catch (IndexOutOfBoundsException iobe) {}
	}
}	

