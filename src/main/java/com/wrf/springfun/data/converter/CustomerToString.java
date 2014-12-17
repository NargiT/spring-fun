package com.wrf.springfun.data.converter;

import com.wrf.springfun.entity.Customer;
import org.dozer.CustomConverter;
import org.dozer.MappingException;

/**
 * Created by nargit on 15/12/2014.
 */
public class CustomerToString implements CustomConverter {

	@Override
	public Object convert(Object destination, Object source, Class destinationClass, Class sourceClass) {
		if (source == null) {
			return null;
		}

		StringBuilder dest = new StringBuilder();
		if (source instanceof Customer) {
			if (destination != null) {
				dest.append(destination.toString());
			}
			dest.append(((Customer) source).getFirstName())
					.append(",")
					.append(((Customer) source).getLastName());
		} else {
			String template = "%s is not bi directional";
			throw new MappingException(String.format(template, this.getClass().getCanonicalName()));
		}
		dest.trimToSize();
		return dest.toString();
	}
}
