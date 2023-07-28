package documinTestes;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import documin.DocumentoController;

class DocumentoControllerTest {
	
	private DocumentoController docController;

	@BeforeEach
	void setUp() {
		this.docController = new DocumentoController();
		docController.criarDocumento("fmcc2");
	}

	@Test
	void testCriarDocumento() {
		boolean t1 = docController.criarDocumento("lp2");
		assertTrue(t1);
		boolean t2 = docController.criarDocumento("lp2");
		assertFalse(t2);
		boolean t3 = docController.criarDocumento("lp1", 5);
		assertTrue(t3);
		boolean t4 = docController.criarDocumento("lp1", 4);
		assertFalse(t4);
	}
	@Test
	void testCriarDocumentoExceptions() {
		try {
			docController.criarDocumento(null);
		} catch (NullPointerException npe) {}
		try {
			docController.criarDocumento("");
		} catch (IllegalArgumentException iae) {}
		try {
			docController.criarDocumento(null, 2);
		} catch (NullPointerException npe) {}
		try {
			docController.criarDocumento("", 3);
		} catch (IllegalArgumentException iae) {}
		try {
			docController.criarDocumento("lp3", 0);
		} catch (IllegalArgumentException iae) {}
	}
	
	@Test
	void testRemoverDocumento() {
		docController.criarDocumento("lp1");
		docController.criarDocumento("lp2");
		assertEquals("Documento [titulo=fmcc2] Documento [titulo=lp1] Documento [titulo=lp2]", docController.getToStringDocumentos());
		docController.removerDocumento("lp1");
		assertEquals("Documento [titulo=fmcc2] Documento [titulo=lp2]", docController.getToStringDocumentos());
	}
	@Test
	void testRemoverDocumentoExceptions() {
		try {
			docController.removerDocumento(null);
		} catch (NullPointerException npe) {}
		try {
			docController.removerDocumento("");
		} catch (IllegalArgumentException iae) {}
		try {
			docController.removerDocumento("lp3");
		} catch (NoSuchElementException nsee) {}
	}
	@Test
	void testCriarTexto() {
		int t1 = docController.criarTexto("fmcc2", "Grupos", 3);
		assertEquals(0, t1);
		int t2 = docController.criarTexto("fmcc2", "Anéis", 2);
		assertEquals(1, t2);
	}
	@Test 
	void testCriarTextoExceptions() {
		try {
			docController.criarTexto(null, null, 3);
		} catch (NullPointerException npe) {}
		try {
			docController.criarTexto("", "Grupos", 3);
		} catch (IllegalArgumentException npe) {}
		try {
			docController.criarTexto("fmcc2", "", 3);
		} catch (IllegalArgumentException iae) {}
		try {
			docController.criarTexto("fmcc2", "", 2);
		} catch (IllegalArgumentException iae) {}
		try {
			docController.criarTexto("lp3", "Grupos", 4);
		} catch (NoSuchElementException nsee) {}
		try {
			docController.criarTexto("fmcc2", "Grupos", 6);
		} catch (IllegalArgumentException iae) {}
		try {
			docController.criarTexto("fmcc2", "Grupos", -1);
		} catch (IllegalArgumentException iae) {}
	}
	@Test
	void testCriarTitulo() {
		int t1 = docController.criarTitulo("fmcc2", "Grupos", 3, 4, true);
		assertEquals(0, t1);
		int t2 = docController.criarTitulo("fmcc2", "Anéis", 2, 3, false);
		assertEquals(1, t2);
	}
	@Test
	void testCriarTituloExceptions() {
		try {
			docController.criarTitulo(null, "Grupos", 3, 4, true);
		} catch (NullPointerException npe) {}
		try {
			docController.criarTitulo("", "Grupos", 3, 2, false);
		} catch (IllegalArgumentException iae) {}
		try {
			docController.criarTitulo("fmcc2", "", 3, 2, false);
		} catch (IllegalArgumentException iae) {}
		try {
			docController.criarTitulo("lp3", "Grupos", 4, 5, true);
		} catch (NoSuchElementException nsee) {}
		try {
			docController.criarTitulo("fmcc2", "Grupos", 6, 3, true);
		} catch (IllegalArgumentException iae) {}
		try {
			docController.criarTitulo("fmcc2", "Grupos", -1, 2, true);
		} catch (IllegalArgumentException iae) {}
		try {
			docController.criarTitulo("fmcc2", "Grupos", 2, 7, true);
		} catch (IllegalArgumentException iae) {}
		try {
			docController.criarTitulo("fmcc2", "Grupos", 3, -3, true);
		} catch (IllegalArgumentException iae) {}
	}
	@Test
	void testCriarLista() {
		int t1 = docController.criarLista("fmcc2", "Grupos / Anéis", 4, "/", "-");
		assertEquals(0, t1);
		int t2 = docController.criarLista("fmcc2", "Anéis / Polinômios", 2, "/", "~");
		assertEquals(1, t2);
	}
	@Test
	void testCriarListaExceptions() {
		try {
			docController.criarLista(null, "Grupos / Anéis", 5, "/", "-");
		} catch (NullPointerException npe) {}
		try {
			docController.criarLista("", "Grupos / Anéis", 5, "/", "-");
		} catch (IllegalArgumentException iae) {}
		try {
			docController.criarLista("fmcc2", "", 5, "/", "-");
		} catch (IllegalArgumentException iae) {}
		try {
			docController.criarLista("lp3", "Grupos / Anéis", 5, "/", "-");
		} catch (NoSuchElementException nsee) {}
		try {
			docController.criarLista("fmcc2", "Grupos / Anéis", 6, "/", "-");
		} catch (IllegalArgumentException iae) {}
		try {
			docController.criarLista("fmcc2", "Grupos / Anéis", -1, "/", "-");
		} catch (IllegalArgumentException iae) {}
	}
	@Test
	void testCriarTermo() {
		int t1 = docController.criarTermo("fmcc2", "Grupos / Anéis", 4, "/", "ALFABÉTICA");
		assertEquals(0, t1);
		int t2 = docController.criarTermo("fmcc2", "Anéis / Polinômios", 2, "/", "NENHUM");
		assertEquals(1, t2);
		int t3 = docController.criarTermo("fmcc2", "Anéis / Polinômios", 2, "/", "TAMANHO");
		assertEquals(2, t3);
	}
	@Test
	void testCriarTermosExceptions() {
		try {
			docController.criarTermo(null, null, 5, null, null);
		} catch (NullPointerException npe) {}
		try {
			docController.criarTermo("", "Grupos / Anéis", 5, "/", "ALFABÉTICA");
		} catch (IllegalArgumentException iae) {}
		try {
			docController.criarTermo("fmcc2", "", 5, "/", "ALFABÉTICA");
		} catch (IllegalArgumentException iae) {}
		try {
			docController.criarTermo("fmcc2", "Grupos / Anéis", 5, "/", "");
		} catch (IllegalArgumentException iae) {}
		try {
			docController.criarTermo("lp3", "Grupos / Anéis", 5, "/", "ALFABÉTICA");
		} catch (NoSuchElementException nsee) {}
		try {
			docController.criarTermo("fmcc2", "Grupos / Anéis", 6, "/", "ALFABÉTICA");
		} catch (IllegalArgumentException iae) {}
		try {
			docController.criarTermo("fmcc2", "Grupos / Anéis", -1, "/", "ALFABÉTICA");
		} catch (IllegalArgumentException iae) {}
	}
	@Test
	void testContarElementos() {
		int t1 = docController.contarElementos("fmcc2");
		assertEquals(0, t1);
		docController.criarLista("fmcc2", "Grupos / Anéis", 4, "/", "-");
		docController.criarTermo("fmcc2", "Grupos / Anéis", 4, "/", "ALFABÉTICA");
		int t2 = docController.contarElementos("fmcc2");
		assertEquals(2, t2);
		
		docController.criarDocumento("lp2", 10);
		docController.criarTexto("lp2", "Java", 3);
		docController.criarTexto("lp2", "Interface", 3);
		int t3 = docController.contarElementos("lp2");
		assertEquals(2, t3);
	}
	@Test
	void testContarElementoException() {
		try {
			docController.contarElementos(null);
		} catch (NullPointerException npe) {}
		try {
			docController.contarElementos("");
		} catch (IllegalArgumentException iae) {}
		try {
			docController.contarElementos("lp3");
		} catch (NoSuchElementException nsee) {}
	}
	@Test
	void testExibirDocumento() {
		assertEquals("[]", Arrays.toString(docController.exibirDocumento("fmcc2")));
		docController.criarLista("fmcc2", "Grupos / Anéis", 4, "/", "-");
		docController.criarTermo("fmcc2", "Grupos / Anéis", 4, "/", "ALFABÉTICA");
		String t = Arrays.toString(docController.exibirDocumento("fmcc2"));
		assertEquals("[Grupos / Anéis, Anéis / Grupos]", t);
	}
	@Test
	void testExibirDocumentoExceptions() {
		try {
			docController.exibirDocumento(null);
		} catch (NullPointerException npe) {}
		try {
			docController.exibirDocumento("");
		} catch (IllegalArgumentException iae) {}
		try {
			docController.exibirDocumento("lp3");
		} catch (NoSuchElementException nsee) {}
	}
	@Test
	void testpegarRepresentacaoCompleta() {
		docController.criarTexto("fmcc2", "Grupos", 3);
		String t1 = docController.pegarRepresentacaoCompleta("fmcc2", 0);
		assertEquals("Grupos", t1);
		
		docController.criarTitulo("fmcc2", "Grupos", 2, 5, false);
		docController.criarTitulo("fmcc2", "Grupos", 2, 5, true);
		String t2 = docController.pegarRepresentacaoCompleta("fmcc2", 1);
		String t3 = docController.pegarRepresentacaoCompleta("fmcc2", 2);
		assertEquals("5. Grupos", t2);
		assertEquals("5 Grupos -- 5-GRUPOS", t3);
		
		docController.criarLista("fmcc2", "Grupos / Anéis / Polinômios", 3, "/", "~");
		String t4 = docController.pegarRepresentacaoCompleta("fmcc2", 3);
		assertEquals("~ Grupos\n~ Anéis\n~ Polinômios", t4);
		
		docController.criarTermo("fmcc2", "Grupos / Anéis / Polinômios", 3, "/", "ALFABÉTICA");
		docController.criarTermo("fmcc2", "Anéis / Grupo / Polinômios", 3, "/", "tamanho");
		docController.criarTermo("fmcc2", "Grupos / Anéis / Polinômios", 3, "/", "Nenhum");
		docController.criarTermo("fmcc2", "Polinômios - TecnicasDemonstração - TeoremaChines", 3, "-", "TAMANHO");
		String t5 = docController.pegarRepresentacaoCompleta("fmcc2", 4);
		String t6 = docController.pegarRepresentacaoCompleta("fmcc2", 5);
		String t7 = docController.pegarRepresentacaoCompleta("fmcc2", 6);
		String t8 = docController.pegarRepresentacaoCompleta("fmcc2", 7);
		assertEquals("Total termos: 3\n- Anéis, Grupos, Polinômios", t5);
		assertEquals("Total termos: 3\n- Polinômios, Anéis, Grupo", t6);
		assertEquals("Total termos: 3\nGrupos, Anéis, Polinômios", t7);
		assertEquals("Total termos: 3\n- TecnicasDemonstração, TeoremaChines, Polinômios", t8);
		
		docController.criarDocumento("lp2");
		
		docController.criarTexto("lp2", "Texto", 4);
		docController.criarTitulo("lp2", "Titulo", 5, 1, true);
		docController.criarTermo("lp2", "Termo / Teste", 2, "/", "Alfabética");
		docController.criarLista("lp2", "Lista / Teste", 4, "/", "=");
		docController.criarTermo("lp2", "Termo / Teste2", 5, "/", "tamanho");
		
		docController.criarAtalho("fmcc2", "lp2");
		String t9 = docController.pegarRepresentacaoCompleta("fmcc2", 8);
		assertEquals("Texto 1 Titulo -- 1-TITULO = Lista\n"
				+ "= Teste Total termos: 2\n"
				+ "- Teste2, Termo", t9);
	}
	
	@Test
	void testPegarRepresentacaoCompletaExceptions() {
		try {
			docController.pegarRepresentacaoCompleta("", 0);
		} catch (IllegalArgumentException iae) {}
		try {
			docController.pegarRepresentacaoCompleta("fmcc2", -2);
		} catch (IllegalArgumentException iae) {}
		try {
			docController.pegarRepresentacaoCompleta("lp3", 0);
		} catch (NoSuchElementException nsee) {}
		try {
			docController.criarTermo("fmcc2", "Exception / Ordem", 3, "/", "todas");
			docController.pegarRepresentacaoCompleta("fmcc2", 0);
		} catch (IllegalArgumentException iae) {}
	}
	
	@Test
	void testPegarRepresentacaoResumida() {
		docController.criarTexto("fmcc2", "Grupos", 3);
		String t1 = docController.pegarRepresentacaoResumida("fmcc2", 0);
		assertEquals("Grupos", t1);
		
		docController.criarTitulo("fmcc2", "Grupos", 2, 5, false);
		docController.criarTitulo("fmcc2", "Grupos", 2, 5, true);
		String t2 = docController.pegarRepresentacaoResumida("fmcc2", 1);
		String t3 = docController.pegarRepresentacaoResumida("fmcc2", 2);
		assertEquals("5. Grupos", t2);
		assertEquals("5. Grupos", t3);
		
		docController.criarLista("fmcc2", "Grupos / Anéis / Polinômios", 3, "/", "~");
		String t4 = docController.pegarRepresentacaoResumida("fmcc2", 3);
		assertEquals("Grupos / Anéis / Polinômios", t4);
		
		docController.criarTermo("fmcc2", "Grupos / Anéis / Polinômios", 3, "/", "ALFABÉTICA");
		docController.criarTermo("fmcc2", "Anéis / Grupo / Polinômios", 3, "/", "tamanho");
		docController.criarTermo("fmcc2", "Grupos / Anéis / Polinômios", 3, "/", "Nenhum");
		docController.criarTermo("fmcc2", "Polinômios - TecnicasDemonstração - TeoremaChines", 3, "-", "TAMANHO");
		String t5 = docController.pegarRepresentacaoResumida("fmcc2", 4);
		String t6 = docController.pegarRepresentacaoResumida("fmcc2", 5);
		String t7 = docController.pegarRepresentacaoResumida("fmcc2", 6);
		String t8 = docController.pegarRepresentacaoResumida("fmcc2", 7);
		assertEquals("Anéis / Grupos / Polinômios", t5);
		assertEquals("Polinômios / Anéis / Grupo", t6);
		assertEquals("Grupos / Anéis / Polinômios", t7);
		assertEquals("TecnicasDemonstração - TeoremaChines - Polinômios", t8);
		
		docController.criarDocumento("lp2");
		
		docController.criarTexto("lp2", "Texto", 4);
		docController.criarTitulo("lp2", "Titulo", 5, 1, true);
		docController.criarTermo("lp2", "Termo / Teste", 2, "/", "Alfabética");
		docController.criarLista("lp2", "Lista / Teste", 4, "/", "=");
		docController.criarTermo("lp2", "Termo / Teste2", 5, "/", "tamanho");
		
		docController.criarAtalho("fmcc2", "lp2");
		String t9 = docController.pegarRepresentacaoResumida("fmcc2", 8);
		assertEquals("Texto 1. Titulo Lista / Teste Teste2 / Termo", t9);
	}
	@Test
	void testPegarRepresentacaoResumidaExceptions() {
		try {
			docController.pegarRepresentacaoResumida("", 0);
		} catch (IllegalArgumentException iae) {}
		try {
			docController.pegarRepresentacaoResumida("fmcc2", -2);
		} catch (IllegalArgumentException iae) {}
		try {
			docController.pegarRepresentacaoResumida("lp3", 0);
		} catch (NoSuchElementException nsee) {}
		try {
			docController.criarTermo("fmcc2", "Exception / Ordem", 3, "/", "várias");
			docController.pegarRepresentacaoResumida("fmcc2", 0);
		} catch (IllegalArgumentException iae) {}
	}
	@Test
	void testMoverParaCima() {
		docController.criarLista("fmcc2", "Divisões / Anéis", 4, "/", "-");
		docController.criarTermo("fmcc2", "Grupos / Polinômios", 4, "/", "ALFABÉTICA");
		
		assertEquals("[Divisões / Anéis, Grupos / Polinômios]", docController.getElementosDeUmDocumento("fmcc2"));
		docController.moverParaCima("fmcc2", 1);
		assertEquals("[Grupos / Polinômios, Divisões / Anéis]", docController.getElementosDeUmDocumento("fmcc2"));
		docController.moverParaCima("fmcc2", 0);
		assertEquals("[Grupos / Polinômios, Divisões / Anéis]", docController.getElementosDeUmDocumento("fmcc2"));
	}
	@Test
	void testMoverParaCimaExceptions() {
		try {
			docController.moverParaCima("", 0);
		} catch (IllegalArgumentException iae) {}
		try {
			docController.moverParaCima("fmcc2", -2);
		} catch (IllegalArgumentException iae) {}
		try {
			docController.moverParaCima("lp3", 0);
		} catch (NoSuchElementException nsee) {}
	}
	@Test
	void testMoverParaBaixo() {
		docController.criarLista("fmcc2", "Divisões / Anéis", 4, "/", "-");
		docController.criarTermo("fmcc2", "Grupos / Polinômios", 4, "/", "ALFABÉTICA");
		
		assertEquals("[Divisões / Anéis, Grupos / Polinômios]", docController.getElementosDeUmDocumento("fmcc2"));
		docController.moverParaBaixo("fmcc2", 0);
		assertEquals("[Grupos / Polinômios, Divisões / Anéis]", docController.getElementosDeUmDocumento("fmcc2"));
		docController.moverParaBaixo("fmcc2", 1);
		assertEquals("[Grupos / Polinômios, Divisões / Anéis]", docController.getElementosDeUmDocumento("fmcc2"));
	}
	@Test
	void testMoverParaBaixoExceptions() {
		try {
			docController.moverParaBaixo("", 0);
		} catch (IllegalArgumentException iae) {}
		try {
			docController.moverParaBaixo("fmcc2", -2);
		} catch (IllegalArgumentException iae) {}
		try {
			docController.moverParaBaixo("lp3", 0);
		} catch (NoSuchElementException nsee) {}
	}
	@Test
	void testApagarElemento() {
		docController.criarLista("fmcc2", "Divisões / Anéis", 4, "/", "-");
		docController.criarTermo("fmcc2", "Grupos / Polinômios", 4, "/", "ALFABÉTICA");
		
		assertEquals("[Divisões / Anéis, Grupos / Polinômios]", docController.getElementosDeUmDocumento("fmcc2"));
		docController.apagarElemento("fmcc2", 0);
		assertEquals("[Grupos / Polinômios]", docController.getElementosDeUmDocumento("fmcc2"));
	}
	@Test
	void testGetElementosDeUmDocumentoExceptions() {
		try {
			docController.getElementosDeUmDocumento("");
		} catch (IllegalArgumentException iae) {}
		try {
			docController.getElementosDeUmDocumento("lp3");
		} catch (NoSuchElementException nsee) {}
	}
	@Test
	void testApagarElementoExceptions() {
		try {
			docController.apagarElemento("", 0);
		} catch (IllegalArgumentException iae) {}
		try {
			docController.apagarElemento("fmcc2", -2);
		} catch (IllegalArgumentException iae) {}
		try {
			docController.apagarElemento("lp3", 0);
		} catch (NoSuchElementException nsee) {}
	}
	@Test
	void testCriarAtalho() {
		docController.criarDocumento("lp2");
		docController.criarTexto("lp2", "Java", 3);
		assertFalse(docController.getDocumentos().get("lp2").getEhAtalho());
		assertFalse(docController.getDocumentos().get("fmcc2").getTemAtalho());
		
		docController.criarAtalho("fmcc2", "lp2");
		assertTrue(docController.getDocumentos().get("fmcc2").getTemAtalho());
		assertTrue(docController.getDocumentos().get("lp2").getEhAtalho());
	}
	@Test
	void testCriarAtalhoExceptions() {
		docController.criarDocumento("lp2");
		docController.criarDocumento("p2");
		docController.criarTexto("p2", "JavaDoc", 2);
		docController.criarTexto("lp2", "Java", 3);
		
		docController.criarAtalho("fmcc2", "lp2");
		try {
			docController.criarAtalho("fmcc2", "p2");
		} catch (IllegalStateException ise) {}
		try {
			docController.criarAtalho("p2", "lp2");
		} catch (IllegalStateException ise) {}
		try {
			docController.criarAtalho("", "p2");
		} catch (IllegalArgumentException iae) {}
		try {
			docController.criarAtalho("p2", "");
		} catch (IllegalArgumentException iae) {}
		try {
			docController.criarAtalho("lp3", "p2");
		} catch (NoSuchElementException nsee) {}
		try {
			docController.criarAtalho("p2", "lp3");
		} catch (NoSuchElementException nsee) {}
		try {
			docController.criarDocumento("p3");
			docController.criarAtalho("lp2", "p3");
		} catch (IllegalStateException ise) {}
	}
}