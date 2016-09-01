package melomano.dominio.daoHbm

import melomano.dominio.Cancion
import java.util.List
import melomano.dominio.hbmUtils.SessionManager
import org.hibernate.criterion.Restrictions

class CancionDao extends GenericDao<Cancion> {
	
	new() {
		super(Cancion)
	}
	
	
	def getPorGenero(String genero){
		SessionManager.getSession.createCriteria(Cancion).add(Restrictions.like("genero",genero)).add(Restrictions.sqlRestriction("1=1 order by rand()")).setMaxResults(5).list as List<Cancion>
		
	}
	
}