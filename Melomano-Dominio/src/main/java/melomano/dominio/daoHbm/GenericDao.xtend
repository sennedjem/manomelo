package melomano.dominio.daoHbm

import melomano.dominio.hbmUtils.SessionManager
import java.util.List


class GenericDao<T> {

	Class<T> modelType

	new(Class<T> modelType) {
		this.modelType = modelType
	}

	def save(T t) {
		SessionManager.getSession.saveOrUpdate(t)
	}

	def getAll() {
		SessionManager.getSession().createCriteria(modelType).list as List<T>
	}

	def delete(T t) {
		SessionManager.getSession().delete(t)
	}

	def deleteAll() {
		SessionManager.session.createQuery("delete from "+modelType.simpleName).executeUpdate
	}
}

	

