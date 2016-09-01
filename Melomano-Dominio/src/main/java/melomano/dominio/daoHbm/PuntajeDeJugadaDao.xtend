package melomano.dominio.daoHbm

import melomano.dominio.PuntajeDeJugada
import melomano.dominio.hbmUtils.SessionManager
import org.hibernate.criterion.Restrictions
import java.util.List

class PuntajeDeJugadaDao extends GenericDao<PuntajeDeJugada>{
	
	new() {
		super(PuntajeDeJugada)
	}
	
//	def getPorGenero(String genero){
//		  SessionManager.getSession().createCriteria(PuntajeDeJugada).add(Restrictions.like("genero",genero)).list as List<PuntajeDeJugada>
//		
//	}
	def getPorGenero(String genre){ 
		SessionManager.getSession().createQuery("
			from PuntajeDeJugada  where genero = :genre order by puntaje desc")
			.setParameter("genre",genre).setMaxResults(10).list as List<PuntajeDeJugada>
	}
	
	def get10(){ 
		SessionManager.getSession().createQuery("
			from PuntajeDeJugada order by puntaje desc")
			.setMaxResults(10).list as List<PuntajeDeJugada>
	}
}