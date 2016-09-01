package melomano.dominio

import melomano.dominio.daoHbm.PuntajeDeJugadaDao
import org.junit.Before
import org.junit.After
import melomano.dominio.hbmUtils.SessionManager
import org.junit.Test
import static org.junit.Assert.*
import java.util.List

class DaoPuntajesTestCase {
	var PuntajeDeJugada puntaje1
	var PuntajeDeJugada puntaje2
	var PuntajeDeJugada puntaje3
	var PuntajeDeJugadaDao dao

	@Before
	def void setUp(){
		
		
		
		puntaje1 = new PuntajeDeJugada("seb",10,"rock")
		puntaje2 = new PuntajeDeJugada("jav",10,"electronica")
		puntaje3= new PuntajeDeJugada("leo",10,"tango")
		dao = new PuntajeDeJugadaDao
	}
	
	@After
	def void tearDown(){
		SessionManager.runInSession[|
		dao.delete(puntaje1)
		dao.delete(puntaje2)
		dao.delete(puntaje3)
		puntaje1=null
		puntaje2=null
		puntaje3=null
		dao= null
		]
	}
	
	@Test def void testSave(){
		SessionManager.runInSession[|
			dao.save(puntaje1)
			var Integer expected = 1
			var Integer actual = dao.getAll.size
			assertEquals(expected, actual)
			1
		]
		
	} 
	
	@Test def void testGetAll(){
		SessionManager.runInSession[|
			dao.save(puntaje1)
			dao.save(puntaje2)
			var List<PuntajeDeJugada> canciones = dao.getAll
			assertTrue(canciones.length().equals(2))
			assertTrue(canciones.contains(puntaje1))
			assertTrue(canciones.contains(puntaje2))
			1
		]
	}
	
	@Test def void testDelete(){
		SessionManager.runInSession[|
			dao.save(puntaje1)
			dao.save(puntaje3)
			var List<PuntajeDeJugada> canciones = dao.getAll
			assertTrue(canciones.length().equals(2))
			assertTrue(canciones.contains(puntaje1))
			assertTrue(canciones.contains(puntaje3))
			dao.delete(puntaje3)
			canciones = dao.getAll
			assertTrue(canciones.length().equals(1))
			assertTrue(canciones.contains(puntaje1))
			assertFalse(canciones.contains(puntaje2))
			assertFalse(canciones.contains(puntaje3))
			1
		]
	}
	
	@Test def void testGetPorGenero(){
//		SessionManager.runInSession[|
//			dao.save(cancion1)
//			dao.save(cancion2)
//			var List<Cancion> canciones = dao.getPorGenero("pop")
//			assertTrue(canciones.length().equals(2))
//			assertTrue(canciones.contains(cancion1))
//			assertTrue(canciones.contains(cancion2))
//			1
//		]
		
	}
	
}