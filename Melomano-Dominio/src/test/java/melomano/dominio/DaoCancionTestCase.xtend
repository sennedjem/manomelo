package melomano.dominio


import melomano.dominio.daoHbm.CancionDao
import melomano.dominio.hbmUtils.SessionManager
import org.junit.Before
import org.junit.Test
import org.junit.After
import static org.junit.Assert.*
import java.util.List


class DaoCancionTestCase {
	var Cancion cancion1
	var Cancion cancion2
	var Cancion cancion3
	var CancionDao dao

	@Before
	def void setUp(){
		/*cancion1 = new Cancion("diez años despues","si diez ___ despues te vuelvo a _____  en algun lugar no
te olvides que soy distinto de aquel, pero casi igual","años","encontrar","en que cd se publico esta cancion?",
"en que año?", "como se llama el tema?","a que banda pertenece?","Palabras mas palabras menos","1995","Diez años despues","Los Rodriguez","rock")
		cancion2 = new Cancion("Perro amor explota","muy lejos del ___, se enciende otra _____ , y crece en sus ojos,
 como un destello que no te deja dormir","mar","sal","en que cd se publico esta cancion?",
"en que año?", "como se llama el tema?","cual es el nombre completo de la banda a que pertenece?","De la Cabeza","2002","Perro amor explota","Bersuit Vergarabat","rock")
		cancion3 = new Cancion("Bajan","Tengo tiempo para saber si lo que ____ concluye en algo,No te apures ya mas,
 loco, porque es entonces cuando las horas___","sueño","bajan","en que cd se publico esta cancion?",
"cual es el apodo del principal integrante de la banda?", "como se llama el tema?","cual es el nombre de la banda a que pertenece?"
,"Artaud","flaco","Bajan","Pescado Rabioso","rock")
		
		dao = new CancionDao
	*/
	}
	
	@After
	def void tearDown(){
		SessionManager.runInSession[|
		dao.delete(cancion1)
		dao.delete(cancion2)
		dao.delete(cancion3)
		cancion1=null
		cancion2=null
		cancion3=null
		dao= null
		]
	}
	
	@Test def void testSave(){
		SessionManager.runInSession[|
			dao.save(cancion1)
			var Integer expected = 1
			var Integer actual = dao.getAll.size
			assertEquals(expected, actual)
			1
		]
		
	} 
	
	@Test def void testGetAll(){
		SessionManager.runInSession[|
			dao.save(cancion1)
			dao.save(cancion2)
			var List<Cancion> canciones = dao.getAll
			assertTrue(canciones.length().equals(2))
			assertTrue(canciones.contains(cancion1))
			assertTrue(canciones.contains(cancion2))
			1
		]
	}
	
	@Test def void testDelete(){
		SessionManager.runInSession[|
			dao.save(cancion1)
			dao.save(cancion3)
			var List<Cancion> canciones = dao.all
			assertTrue(canciones.length().equals(2))
			assertTrue(canciones.contains(cancion1))
			assertTrue(canciones.contains(cancion3))
			dao.delete(cancion3)
			canciones = dao.all
			assertTrue(canciones.length().equals(1))
			assertTrue(canciones.contains(cancion1))
			assertFalse(canciones.contains(cancion2))
			assertFalse(canciones.contains(cancion3))
			1
		]
	}
	
	@Test def void testGetPorGenero(){
		SessionManager.runInSession[|
			dao.save(cancion1)
			dao.save(cancion2)
			var List<Cancion> canciones = dao.getPorGenero("pop")
			assertTrue(canciones.length().equals(2))
			assertTrue(canciones.contains(cancion1))
			assertTrue(canciones.contains(cancion2))
			1
		]
		
	}
	
}