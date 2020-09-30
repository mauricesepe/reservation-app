package jp.co.liferay.headless.reservation.internal.jaxrs.application;

import javax.annotation.Generated;

import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

/**
 * @author Maurice Sepe
 * @generated
 */
@Component(
	property = {
		"osgi.jaxrs.application.base=/reservation-headless",
		"osgi.jaxrs.extension.select=(osgi.jaxrs.name=Liferay.Vulcan)",
		"osgi.jaxrs.name=jp.co.liferay.headless.reservation"
	},
	service = Application.class
)
@Generated("")
public class HeadlessReservationApplication extends Application {
}