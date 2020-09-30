package jp.co.liferay.headless.reservation.client.function;

import javax.annotation.Generated;

/**
 * @author Maurice Sepe
 * @generated
 */
@FunctionalInterface
@Generated("")
public interface UnsafeSupplier<T, E extends Throwable> {

	public T get() throws E;

}