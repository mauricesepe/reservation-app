package jp.co.liferay.headless.reservation.client.dto.v1_0;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

import jp.co.liferay.headless.reservation.client.function.UnsafeSupplier;
import jp.co.liferay.headless.reservation.client.serdes.v1_0.ParticipantSerDes;

/**
 * @author Maurice Sepe
 * @generated
 */
@Generated("")
public class Participant implements Cloneable, Serializable {

	public static Participant toDTO(String json) {
		return ParticipantSerDes.toDTO(json);
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setCompanyName(
		UnsafeSupplier<String, Exception> companyNameUnsafeSupplier) {

		try {
			companyName = companyNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String companyName;

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setEmailAddress(
		UnsafeSupplier<String, Exception> emailAddressUnsafeSupplier) {

		try {
			emailAddress = emailAddressUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String emailAddress;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setFullName(
		UnsafeSupplier<String, Exception> fullNameUnsafeSupplier) {

		try {
			fullName = fullNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String fullName;

	public Long getParticipantId() {
		return participantId;
	}

	public void setParticipantId(Long participantId) {
		this.participantId = participantId;
	}

	public void setParticipantId(
		UnsafeSupplier<Long, Exception> participantIdUnsafeSupplier) {

		try {
			participantId = participantIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long participantId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setUserId(
		UnsafeSupplier<Long, Exception> userIdUnsafeSupplier) {

		try {
			userId = userIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long userId;

	@Override
	public Participant clone() throws CloneNotSupportedException {
		return (Participant)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Participant)) {
			return false;
		}

		Participant participant = (Participant)object;

		return Objects.equals(toString(), participant.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return ParticipantSerDes.toJSON(this);
	}

}