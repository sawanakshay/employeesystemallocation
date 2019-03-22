package com.analog.employeesystemallocation.jpa.interceptor;

import java.io.Serializable;
import java.util.Arrays;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.springframework.stereotype.Component;

@Component
public class BaseModelInterceptor extends EmptyInterceptor {

	private static final long serialVersionUID = 2442941067449415425L;

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		setValue(state, propertyNames, "createdDate", new java.util.Date());
		return true;
	}

	@Override
	public boolean onFlushDirty(Object entity, Serializable id, Object[] state, Object[] previousState,
			String[] propertyNames, Type[] types) {
		setValue(state, propertyNames, "modifiedDate", new java.util.Date());
		return true;
	}

	public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		setValue(state, propertyNames, "modifiedDate", new java.util.Date());
	}

	private void setValue(Object[] currentState, String[] propertyNames, String propertyToSet, Object value) {
		int index = Arrays.asList(propertyNames).indexOf(propertyToSet);
		if (index >= 0) {
			currentState[index] = value;
		}
	}

}
